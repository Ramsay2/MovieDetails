package com.ramsay.moviedetails.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.ramsay.moviedetails.databinding.ActivityMovieDetailsBinding

class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            tvName.text = "Name : " + intent.getStringExtra("title")

            tvLanguage.text = "Language : " + intent.getStringExtra("originalLanguage")
            tvOverview.text = "Overview : \n" +
                    "" + intent.getStringExtra("overview")
        }


        binding.btnBookTicket.setOnClickListener {
        startActivity(Intent(this,WebViewActivity::class.java))
        }


        val posterLink = intent.getStringExtra("poster")
        Glide
            .with(binding.ivPoster)
            .load("https://image.tmdb.org/t/p/w500/${posterLink}")
            .into(binding.ivPoster)


    }
}