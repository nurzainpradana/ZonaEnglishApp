package com.zn.zonaenglish.ui.login.loginemail

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.zn.zonaenglish.databinding.ActivityLoginEmailBinding
import com.zn.zonaenglish.network.ApiConfig
import com.zn.zonaenglish.ui.login.loginemail.model.LoginResponse
import com.zn.zonaenglish.ui.login.loginpassword.LoginPasswordActivity
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Converter
import retrofit2.Response
import java.io.IOException

class LoginEmailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginEmailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            if (isFormValid(email)) {
                nextToLoginPassword(email)
            }
        }
    }

    private fun nextToLoginPassword(email: String) {
        val loginEmail = LoginRequestEmail(email = email)
        val loginRequestString = Gson().toJson(loginEmail)

        ApiConfig.apiClient().loginEmailRequest(loginRequestString)
            .enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful) {
                        val intent = Intent(this@LoginEmailActivity, LoginPasswordActivity::class.java)
                        intent.putExtra(LoginPasswordActivity.EXTRA_EMAIL, email)
                        startActivity(intent)
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
                                Toast.makeText(this@LoginEmailActivity, "$errorResponse", Toast.LENGTH_SHORT).show()
                            }
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.e("TAG", "onResponse: ${t.message}")
                }
            })
    }

    private fun isFormValid(email: String): Boolean {
        if (email.isEmpty()) {
            binding.etEmail.error = "Please Input Email"
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.etEmail.error = "Please input email is valid"
        } else {
            binding.etEmail.error = null
            return true
        }
        return false
    }

    private fun gotoLoginPassword(email: String) {
        //
    }
}