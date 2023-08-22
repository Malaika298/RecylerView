package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsapp.databinding.ActivityMainBinding
import com.example.newsapp.databinding.ActivityNewsDetailsBinding

class NewsDetails : AppCompatActivity() {

    lateinit var binding: ActivityNewsDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewsDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val newshead = intent.getStringExtra("NewsHeading")
        val newsdetail = intent.getStringExtra("NewsDetails")
        val newsimage = intent.getIntExtra("NewsImage", R.drawable.news1)

        binding.tVdetailsHeading.text = newshead

        binding.tVNewsDetails.text = newsdetail

        binding.imageViewdetails.setImageResource(newsimage)
    }
}