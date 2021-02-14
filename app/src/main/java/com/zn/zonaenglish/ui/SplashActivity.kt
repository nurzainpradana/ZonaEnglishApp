package com.zn.zonaenglish.ui

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.zn.zonaenglish.MainActivity
import com.zn.zonaenglish.R
import com.zn.zonaenglish.hawkstorage.HawkStorage
import com.zn.zonaenglish.ui.login.LoginScreenActivity
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
            checkIfLogin()
            finish()
        }, timeMovieActivity)
    }

    private fun checkIfLogin() {
        val isLogin = HawkStorage.instance(this).isLogin()
        if (isLogin) {
            startActivity<MainActivity>()
            finishAffinity()
        } else {
            startActivity<LoginScreenActivity>()
            finishAffinity()
        }
    }
}