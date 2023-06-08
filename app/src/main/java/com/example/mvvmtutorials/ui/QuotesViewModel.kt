package com.example.mvvmtutorials.ui

import androidx.lifecycle.ViewModel
import com.example.mvvmtutorials.data.Quote
import com.example.mvvmtutorials.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository)
    :ViewModel(){

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)

    }