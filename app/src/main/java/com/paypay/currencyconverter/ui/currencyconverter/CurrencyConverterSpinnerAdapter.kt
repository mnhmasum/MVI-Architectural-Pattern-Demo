package com.paypay.currencyconverter.ui.currencyconverter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.paypay.currencyconverter.R
import com.paypay.currencyconverter.database.models.ExchangeRate
import kotlinx.android.synthetic.main.item_rate.view.*

class CurrencyConverterSpinnerAdapter(ctx: Context, moods: List<ExchangeRate>) : ArrayAdapter<ExchangeRate>(ctx, 0, moods) {

    override fun getView(position: Int, recycledView: View?, parent: ViewGroup): View {
        return this.createView(position, recycledView, parent)
    }

    override fun getDropDownView(position: Int, recycledView: View?, parent: ViewGroup): View {
        return this.createView(position, recycledView, parent)
    }

    private fun createView(position: Int, recycledView: View?, parent: ViewGroup): View {
        val mood = getItem(position)
        val view = recycledView ?: LayoutInflater.from(context).inflate(R.layout.item_rate, parent, false)
        view.textViewTitle.text = mood?.currencyName
        return view
    }
}