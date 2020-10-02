package com.example.democoroutine

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.democoroutine.databinding.ItemQuoteBinding

class QuotesAdapter : RecyclerView.Adapter<QuotesAdapter.QuoteViewHolder>() {
    var quote: List<Quote>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =  QuoteViewHolder(DataBindingUtil.inflate(
        LayoutInflater.from(parent.context),
        R.layout.item_quote,
        parent,
        false))

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        holder.binding.quote = quote!!.get(position)
    }

    override fun getItemCount(): Int {
       return quote?.size ?: 0
    }

    inner class QuoteViewHolder(val binding: ItemQuoteBinding) :
        RecyclerView.ViewHolder(binding.root)
}