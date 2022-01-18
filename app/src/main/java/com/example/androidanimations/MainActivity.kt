package com.example.androidanimations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //adding animation in a text View
        button.setOnClickListener{
            YoYo.with(Techniques.BounceInUp)
                .duration(200)
                .repeat(4)
                .playOn(textView)//the view you want to that
        }
        button2.setOnClickListener {
            var intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
            //the below code must be below startActivity....it's only to go to next activity
            //not coming back
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
//            IMPORTANT
            //go to themes xml file to add animation to whole project instead of adding animation specifically
        }


    }
}