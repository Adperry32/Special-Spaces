package com.example.ssa.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.ssa.R


class SplashActivity : AppCompatActivity() {

    private lateinit var gif: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        gif = findViewById(R.id.animation_gif)
        Glide.with(this)
            .load(R.drawable.ssa_animation)
            .into(gif)

        val handler = Handler()
        handler.postDelayed({startActivity(Intent(this@SplashActivity, MainActivity::class.java ))
        }, 6070)
    }
}