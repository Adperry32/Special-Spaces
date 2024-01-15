package com.example.ssa.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ssa.R
import com.example.ssa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind = ActivityMainBinding.inflate(layoutInflater)
    }
}