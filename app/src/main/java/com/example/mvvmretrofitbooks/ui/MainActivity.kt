package com.example.mvvmretrofitbooks.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmretrofitbooks.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, HomeFragment())
            .addToBackStack(null)
            .commit()
    }
}