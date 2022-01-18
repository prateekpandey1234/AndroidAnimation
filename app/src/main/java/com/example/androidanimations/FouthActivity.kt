package com.example.androidanimations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class FouthActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)
        //to show this animation ....add
        //android:transitionName="example_transition"
        //inside the xml code for the View you want to share between activities
    }

}