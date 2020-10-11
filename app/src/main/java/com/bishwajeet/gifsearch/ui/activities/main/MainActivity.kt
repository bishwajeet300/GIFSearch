package com.bishwajeet.gifsearch.ui.activities.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bishwajeet.gifsearch.R
import com.bishwajeet.gifsearch.ui.fragments.search.GifSearchAction
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etSearch = findViewById<EditText>(R.id.etSearch)
        val txtClose = findViewById<TextView>(R.id.txtClose)

        txtClose.setOnClickListener {
            etSearch.setText("")
            txtClose.visibility = View.GONE
        }

        etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                mainViewModel.receiveUserAction(GifSearchAction.SearchQueryInput(s.toString()))
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })


        mainViewModel.isValidQuery.observe(this,
            Observer { result ->
                result ?: return@Observer

                if (result) {
                    txtClose.visibility = View.VISIBLE
                } else {
                    txtClose.visibility = View.GONE
                }
            })
    }


}