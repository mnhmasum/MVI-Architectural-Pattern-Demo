package com.paypay.currencyconverter.ui.base

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.paypay.currencyconverter.application.MainApplication
import com.paypay.currencyconverter.dependencyinjection.ActivityModule
import com.paypay.currencyconverter.dependencyinjection.DaggerMainActivityComponent
import com.paypay.currencyconverter.dependencyinjection.MainActivityComponent
import com.paypay.currencyconverter.utils.enableIntervalAPICallAlarmService

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {
    lateinit var binding: T
    abstract fun getLayoutResource(): Int
    abstract fun initComponents()
    abstract fun performDependencyInjection(activityComponent: MainActivityComponent)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutResource())
        binding.lifecycleOwner = this
        setContentView(binding.root)
        performDependencyInjection(getActivityComponent())
        initComponents()
        enableIntervalAPICallAlarmService()
    }

    private fun getActivityComponent(): MainActivityComponent {
        return DaggerMainActivityComponent.builder()
            .applicationComponent((application as MainApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()
    }

    open fun startActivity(cls: Class<*>?, finishSelf: Boolean) {
        val intent = Intent(this, cls)
        startActivity(intent)
        if (finishSelf) {
            finish()
        }
    }

    fun toast(message: String) {
        Toast.makeText(this, "Toast: $message", Toast.LENGTH_SHORT).show()
    }

}