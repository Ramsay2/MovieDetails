package com.ramsay.moviedetails.view

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ramsay.moviedetails.R
import com.ramsay.moviedetails.adapter.DataAdapter
import com.ramsay.moviedetails.databinding.ActivityMainBinding
import com.ramsay.moviedetails.viewModels.ViewModels


class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var dataAdapter: DataAdapter

    private val viewModel: ViewModels by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        setAdapter()
        getData()
        swipe()
    }

    private fun getData() {

        mainBinding.progressBar.visibility = View.VISIBLE
        mainBinding.layoutProgress.visibility = View.VISIBLE
        viewModel.liveData.observe(this, {
            mainBinding.progressBar.visibility = View.GONE
            mainBinding.layoutProgress.visibility = View.GONE
            dataAdapter.newList(it.results)
        })
    }

    private fun setAdapter() {
        dataAdapter = DataAdapter()
        mainBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        mainBinding.recyclerView.adapter = dataAdapter

    }

    private fun swipe() {
        mainBinding.swipeContainer.setProgressBackgroundColorSchemeColor(ContextCompat.getColor(this, R.color.black))
        mainBinding.swipeContainer.setColorSchemeColors(Color.WHITE)
        mainBinding.swipeContainer.setOnRefreshListener {
            getData()
            mainBinding.recyclerView.adapter = dataAdapter
            mainBinding.swipeContainer.isRefreshing = false

        }
    }
}