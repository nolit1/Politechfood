package com.example.politechfood.mainPackage.singleCafePackage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.politechfood.R
import kotlinx.android.synthetic.main.activity_create_comment.*

class ActivityCreateComment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_comment)


        create_comment_btn_save.setOnClickListener {
            finish()
        }
    }

}