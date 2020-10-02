package com.example.democoroutine

data class QuotesResponse(
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)