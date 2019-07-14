package com.example.politechfood.registrationPackage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.politechfood.MainActivity
import com.example.politechfood.R
import com.example.politechfood.common.MyPreference
import com.example.politechfood.common.verifyAvailableNetwork
import kotlinx.android.synthetic.main.activity_registration.*

class ActivityRegistration : AppCompatActivity() {


    private lateinit var email: String
    private lateinit var password: String
    private lateinit var name: String
    private lateinit var surname: String
    private lateinit var gender: String
    private lateinit var birthDate: String


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)


        reg_btn_registration.setOnClickListener {
            registration()
        }

    }


    private fun registration() {
        email = reg_te_email.text.toString()
        password = reg_te_password.text.toString()
        name = reg_te_name.text.toString()
        surname = reg_te_surname.text.toString()


        if (!verifyAvailableNetwork(this)) {
            Toast.makeText(this, getString(R.string.no_internet_connection), Toast.LENGTH_SHORT).show()
            return
        }

        if (email.isEmpty() || password.isEmpty() || name.isEmpty() || surname.isEmpty()) {
            Toast.makeText(this, R.string.empty_fields, Toast.LENGTH_SHORT).show()
            return
        }

        /**Проверка и вход*/
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