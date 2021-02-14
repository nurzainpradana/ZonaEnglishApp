package com.zn.zonaenglish.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zn.zonaenglish.ui.register.RegisterNameFragment
import com.zn.zonaenglish.databinding.ActivityLoginScreenBinding
import com.zn.zonaenglish.ui.login.loginemail.LoginEmailActivity
import org.jetbrains.anko.startActivity

class LoginScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClick()

    }

    private fun onClick() {
        binding.lLayoutLoginEmail.setOnClickListener {
            startActivity<LoginEmailActivity>()
        }
        binding.lLayoutRegister.setOnClickListener {
            startActivity(Intent(this, RegisterNameFragment::class.java))
        }
    }
}