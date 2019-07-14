package com.example.politechfood.common

import android.content.Context

class MyPreference(context : Context) {

    private val prefs = "SharedPref"

    private val email = "email"
    private val password = "password"

    private val preference = context.getSharedPreferences(prefs, Context.MODE_PRIVATE)


    fun setEmail(mEmail : String?) {
        preference.edit().putString(email, mEmail).apply()
    }

    fun getEmail() : String? {
        return preference.getString(email, null)
    }

    fun setPassword (mPassword : String?) {
        preference.edit().putString(password, mPassword).apply()
    }

    fun getPassword() : String? {
        return preference.getString(password, null)
    }
}