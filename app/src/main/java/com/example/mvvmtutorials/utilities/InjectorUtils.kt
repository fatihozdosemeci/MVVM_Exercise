package com.example.mvvmtutorials.utilities

import com.example.mvvmtutorials.data.FakeDatabase
import com.example.mvvmtutorials.data.QuoteRepository
import com.example.mvvmtutorials.ui.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory{

        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}