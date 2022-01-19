package com.example.androidanimations

import android.graphics.drawable.AnimatedImageDrawable
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_fourth.*
import android.view.ViewAnimationUtils

import android.animation.Animator
import android.view.View
import androidx.core.animation.addListener
import kotlin.math.hypot


class FouthActivity:AppCompatActivity() {
    lateinit var animate1:AnimationDrawable
    var clicked:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)
        clicked = 0
        //to show this animation ....add
        //android:transitionName="example_transition"
        //inside the xml code for the View you want to share between activities

        //animation using icons
        //store the animation inside the drawable file cuz it's a background resource
        imageView2.setBackgroundResource(R.drawable.animation)
        animate1= imageView2.background as AnimationDrawable

//Floating Action button animation
        fab2.setOnClickListener {
            if (clicked%2==0){
                //code for revealing animation
                val cx: Int = it.width / 2
                val cy: Int = it.height / 2

                val finalRadius = hypot((cx).toDouble(), (cy).toDouble()).toFloat()

                val anim = ViewAnimationUtils.createCircularReveal(it, cx, cy, 0f, finalRadius)
                it.visibility = View.VISIBLE
                clicked+=1
                anim.start()
            }
            else{
                //code for closing animation
                val cx: Int = it.width / 2
                val cy: Int = it.height / 2
                clicked+=1
                val finalRadius = hypot((cx).toDouble(), (cy).toDouble()).toFloat()

                val anim = ViewAnimationUtils.createCircularReveal(it, cx, cy, finalRadius, 0f)
                anim.addListener {Animator->
                    it.visibility = View.INVISIBLE
                }
                anim.start()
            }
        }


    }
//The following method gets called when window's focus changes. For instance, if the window
// gains/losses focus, it will be triggered. In case, the window gains focus, hasFocus is true and false otherwise.
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        animate1.start()
    }

}