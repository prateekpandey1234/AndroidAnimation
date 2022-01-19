package com.example.androidanimations

import android.animation.ArgbEvaluator
import android.animation.TimeAnimator
import android.animation.ValueAnimator
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.GradientDrawable
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
        //gradient animation for background of screen
        //you need a gradient also in drawable file and use it as background for the layout you want
        //unless it will show error
        var gradient = layout1.background as GradientDrawable
        val start = Color.DKGRAY
        val mid = Color.MAGENTA
        val end = Color.BLUE

        val animator = TimeAnimator.ofFloat(0.0f, 1.0f)
        animator.duration = 1500
        animator.repeatCount = ValueAnimator.INFINITE
        animator.repeatMode = ValueAnimator.REVERSE
        val evaluator = ArgbEvaluator()
        //This evaluator can be used to perform type interpolation between integer values that represent ARGB colors
        animator.addUpdateListener {
            val fraction = it.animatedFraction
            val newStart = evaluator.evaluate(fraction, start, end) as Int
            val newMid = evaluator.evaluate(fraction, mid, start) as Int
            val newEnd = evaluator.evaluate(fraction, end, mid) as Int

            gradient.colors = intArrayOf(newStart, newMid, newEnd)
        }

        animator.start()


    }
}