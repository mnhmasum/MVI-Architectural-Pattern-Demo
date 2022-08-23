package com.paypay.currencyconverter.utils

import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import androidx.appcompat.widget.AppCompatSpinner
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView
import com.paypay.currencyconverter.database.models.CurrencyResponse
import com.paypay.currencyconverter.database.models.ExchangeRate
import com.paypay.currencyconverter.ui.currencyconverter.CurrencyConverterSpinnerAdapter

@BindingAdapter("setAdapter")
fun setAdapter(
    recyclerView: RecyclerView,
    adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>?
) {
    adapter?.let {
        recyclerView.adapter = it
    }
}

@BindingAdapter(value = ["setCurrencyList"], requireAll = false)
fun setAdapterTest(spinner: Spinner, projects: CurrencyResponse?) {
    projects?.let {
        spinner.adapter = it.exchangeRateList?.let { CurrencyConverterSpinnerAdapter(spinner.context, it) }
        spinner.setSelection(146)
    }
}

@BindingAdapter("changeListener")
fun listenClicks(spinner: AppCompatSpinner, exchangeRate: ObservableField<ExchangeRate>) {
    spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {

        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            exchangeRate.set(parent?.getItemAtPosition(position) as ExchangeRate)
        }
    }
}


