package com.example.democoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val quotesAdapter by lazy { QuotesAdapter() }
    private lateinit var viewModel: QuotesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview_quotes.adapter = quotesAdapter
        viewModel = ViewModelProvider(this).get(QuotesViewModel::class.java)
        viewModel.quote.observe(this, object : Observer<List<Quote>> {
            override fun onChanged(t: List<Quote>?) {
                quotesAdapter.quote = t
            }
        })
    }
}