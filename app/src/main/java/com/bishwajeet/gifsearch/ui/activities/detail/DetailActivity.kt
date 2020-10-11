package com.bishwajeet.gifsearch.ui.activities.detail

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.bishwajeet.gifsearch.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        findNavController(R.id.nav_host_detail_fragment)
            .setGraph(R.navigation.detail_app_navigation, intent.extras)

        findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            finish()
        }
    }
}