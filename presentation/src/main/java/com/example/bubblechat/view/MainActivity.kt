package com.example.bubblechat.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.bubblechat.R
import com.example.bubblechat.databinding.ActivityMainBinding
import com.example.bubblechat.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
    }
    private val viewModel by lazy { ViewModelProvider(this)[MainViewModel::class.java] }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        initBNV()
    }

    private fun replaceFrag(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout,fragment)
            commit()
        }
    }

    private fun initBNV(){
        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.action_friend ->{
                    replaceFrag(FriendFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.action_chat ->{
                    replaceFrag(ChatFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.action_more ->{
                    replaceFrag(MoreFragment())
                    return@setOnItemSelectedListener true
                }

                else -> {
                    return@setOnItemSelectedListener false
                }
            }
        }
    }
}