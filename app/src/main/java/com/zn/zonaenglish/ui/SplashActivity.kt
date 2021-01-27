package com.zn.zonaenglish.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.zn.zonaenglish.MainActivity
import com.zn.zonaenglish.R
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        /**
         *  Handler auto move to Main activity
         */
        val timeMovieActivity = 1200L

        Handler(mainLooper).postDelayed({
            startActivity<MainActivity>()
            finish()
        }, timeMovieActivity)
    }
}