package com.example.androidanimations

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import kotlinx.android.synthetic.main.activity__third.*

class ThirdActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity__third)
        button5.setOnClickListener {
            var intent = Intent(this,FouthActivity::class.java)
            //use the following code to add the transition specifically between these two activities
            var optionsCompat = ViewCompat.getTransitionName(nagataro)?.let { it1 ->
                ActivityOptionsCompat.makeSceneTransitionAnimation(this,nagataro,
                    it1
                )
            }
            if (optionsCompat != null) {
                startActivity(intent,optionsCompat.toBundle())
            }
        }
    }
}