package com.example.prographytest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prographytest.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        detail_title.text = intent.getStringExtra("title").toString()
        detail_director.text = intent.getStringExtra("director").toString()
        detail_release_date.text = intent.getStringExtra("release_date").toString()
        detail_rt_score.text = intent.getStringExtra("rt_score").toString()
        detail_producer.text = intent.getStringExtra("producer").toString()
        detail_description.text = intent.getStringExtra("description").toString()
    }
}
