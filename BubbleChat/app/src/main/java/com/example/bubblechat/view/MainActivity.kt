package com.example.bubblechat.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.bubblechat.R
import com.example.bubblechat.databinding.ActivityMainBinding
import com.example.bubblechat.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { DataBindingUtil.setContentView(this,
        R.layout.activity_main
    )  }
    private val viewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        binding.fab.bringToFront()
    }


}