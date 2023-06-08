package com.example.mvvmtutorials.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmtutorials.R
import com.example.mvvmtutorials.data.Quote
import com.example.mvvmtutorials.utilities.InjectorUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeUi()
    }

    private fun initializeUi(){
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this,factory)
            .get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach{ quote ->
                stringBuilder.append("$quote\n\n")
            }
            val textViewQuotes: TextView = findViewById(R.id.textView_quotes)
            textViewQuotes.text = stringBuilder.toString()
        })

        val button_add_quote : Button = findViewById(R.id.button_add_quote)
        val editTextQuote : EditText = findViewById(R.id.editText_quote)
        val editTextAuthor : EditText = findViewById(R.id.editText_author)
        button_add_quote.setOnClickListener {
            val quote = Quote(editTextQuote.text.toString(), editTextAuthor.text.toString())
            viewModel.addQuote(quote)
            editTextQuote.setText("")
            editTextAuthor.setText("")
        }
    }
}