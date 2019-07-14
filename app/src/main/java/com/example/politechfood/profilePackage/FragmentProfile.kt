package com.example.politechfood.profilePackage

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.politechfood.R
import com.example.politechfood.common.MyPreference
import com.example.politechfood.registrationPackage.ActivityLogin
import kotlinx.android.synthetic.main.fragment_profile.*

class FragmentProfile : Fragment() {

    private var profileName : String ?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Получение из БД
        profileName = "Евгений Конев"

        profile_btn_sign_out.setOnClickListener {
            activity?.finish()
            MyPreference(context!!).setEmail(null)
            MyPreference(context!!).setPassword(null)
            val intent = Intent(context, ActivityLogin::class.java)
            startActivity(intent)
        }

        if (profileName != null) {
            profile_tv_name.text = profileName
        } else {
            profile_tv_name.text = getString(R.string.not_know)
        }
    }
}