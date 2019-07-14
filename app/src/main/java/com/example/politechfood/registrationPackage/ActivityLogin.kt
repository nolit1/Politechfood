package com.example.politechfood.registrationPackage


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.politechfood.MainActivity
import com.example.politechfood.R
import com.example.politechfood.common.MyPreference
import com.example.politechfood.common.verifyAvailableNetwork
import kotlinx.android.synthetic.main.activity_login.*


class ActivityLogin : AppCompatActivity() {


    override fun onStart() {
        super.onStart()

        if (MyPreference(this).getEmail() != null && MyPreference(this).getPassword() != null) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        log_tv_back_to_registration.setOnClickListener {
            val intent = Intent(this, ActivityRegistration::class.java)
            startActivity(intent)
        }

        log_btn_login.setOnClickListener {
            loginFun()
        }

    }

    private fun loginFun() {

        val email = log_te_email.text.toString()
        val password = log_te_password.text.toString()

        if (!verifyAvailableNetwork(this)) {
            Toast.makeText(this, getString(R.string.no_internet_connection), Toast.LENGTH_SHORT).show()
            return
        }

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, R.string.empty_fields, Toast.LENGTH_SHORT).show()
            return
        }

        /**проверка и вход*/
        MyPreference(this).setEmail(email)
        MyPreference(this).setPassword(password)
        intentToMainActivity()
    }

    private fun intentToMainActivity() {
        intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }
}


