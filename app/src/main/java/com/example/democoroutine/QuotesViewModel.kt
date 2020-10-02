package com.example.democoroutine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.democoroutine.network.MyApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class QuotesViewModel : ViewModel() {
    private val TAG = "QuotesViewModel"
    val quote: LiveData<List<Quote>> = MutableLiveData<List<Quote>>()

    init {
        viewModelScope.launch {
            quote as MutableLiveData
            var quote1 = async { getQuotes() }
            val result = quote1.await()
            quote.value = result
        }
    }

    private suspend fun getQuotes(): List<Quote>? {
        return withContext(Dispatchers.IO) {
            android.util.Log.i(TAG, "Getting Quotes")
            MyApi().getQuotes().body()?.quotes
        }

    }
}