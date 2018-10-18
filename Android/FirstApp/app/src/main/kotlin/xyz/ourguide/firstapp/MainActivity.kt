package xyz.ourguide.firstapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button

//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val nextButton = findViewById<Button>(R.id.button_next)
//
//        // 익명의 클래스보다 람다가 편리한 이유?
//        /*
//        nextButton.setOnClickListener(object: View.OnClickListener {
//            override fun onClick(view: View?) {
//                val intent = Intent(this@MainActivity,
//                        SignInActivity::class.java)
//
//                startActivity(intent)
//            }
//        })
//        */
//
//        nextButton.setOnClickListener {
//            val intent = Intent(this, SignInActivity::class.java)
//            startActivity(intent)
//        }
//
//    }
//}








