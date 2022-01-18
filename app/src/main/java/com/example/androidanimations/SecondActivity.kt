package com.example.androidanimations

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import android.widget.ViewSwitcher
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity:AppCompatActivity() {
    private var index:Int = 0
    private var arr = arrayOf<String>("Hello","World","This","Is","Prateek")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        button3.setOnClickListener {
            var intent = Intent(this,ThirdActivity::class.java)
            startActivity(intent)
        }
        button4.setOnClickListener {
            if (index==arr.size-1){
                index=0
                textView2.setText(arr[index])
            }else{
                index+=1
                textView2.setText(arr[index])
            }
        }
        //adding sliding animation to the TextSwitcher
        //u need to create a TextSwitcher and animation in XML file unless it will not run
        textView2.setFactory {
            var textView = TextView(this)
            textView.setTextColor(Color.BLACK)
            textView.setTextSize(60F)
            textView.gravity = Gravity.CENTER_HORIZONTAL
            textView
        }
        textView2.setText(arr[index])

    }

    override fun finish() {
        super.finish()
        //this code below here only applies for animation when we go back to MainActivity
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right)
    }
}
