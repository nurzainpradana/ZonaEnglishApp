package com.zn.zonaenglish.ui.login.loginpassword

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.zn.zonaenglish.MainActivity
import com.zn.zonaenglish.databinding.LoginPasswordActivityBinding
import com.zn.zonaenglish.hawkstorage.HawkStorage
import com.zn.zonaenglish.network.ApiConfig
import com.zn.zonaenglish.ui.login.loginemail.LoginRequest
import com.zn.zonaenglish.ui.login.loginemail.model.LoginResponse
import okhttp3.ResponseBody
import org.jetbrains.anko.startActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Converter
import retrofit2.Response
import java.io.IOException

class LoginPasswordActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_EMAIL = "email"
    }
    private lateinit var binding: LoginPasswordActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginPasswordActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = intent.getStringExtra(EXTRA_EMAIL)

        binding.fabLogin.setOnClickListener {
            val password = binding.etPassword.text.toString()
            if (isFormValid(password)) {
                loginToHome(email, password)
                Toast.makeText(this, "$email, $password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loginToHome(email: String?, password: String) {
        val loginRequest = LoginRequest(email = email, password = password)
        val loginRequestJson = Gson().toJson(loginRequest)

        ApiConfig.apiClient().loginRequest(loginRequestJson)
            .enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful) {
                        val user = response.body()?.user
                        val token = response.body()?.meta?.token
                        HawkStorage.instance(this@LoginPasswordActivity).setUser(user)
                        HawkStorage.instance(this@LoginPasswordActivity).setToken(token)
                        startActivity<MainActivity>()
                    } else {
                        val errorConverter: Converter<ResponseBody, LoginResponse> =
                            ApiConfig.doRequest()
                                .responseBodyConverter(
                                    LoginResponse::class.java,
                                    arrayOfNulls<Annotation>(0)
                                )
                        try {
                            var errorResponse: LoginResponse?
                            response.errorBody()?.let {
                                errorResponse = errorConverter.convert(it)
                                Toast.makeText(this@LoginPasswordActivity, "$errorResponse", Toast.LENGTH_SHORT).show()
                            }
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.e("TAG", "onFailure: ${t.message}")
                }
            })
    }

    private fun isFormValid(password: String): Boolean {
        if (password.isEmpty()) {
            binding.etPassword.error = "Please Input Password"
        } else {
            binding.etPassword.error = null
            return true
        }
        return false
    }

    private fun gotoHome() {
        startActivity<MainActivity>()
    }
}