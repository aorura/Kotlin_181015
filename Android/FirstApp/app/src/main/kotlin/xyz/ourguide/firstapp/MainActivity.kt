package xyz.ourguide.firstapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

// findByViewId는 필요가 없습니다.
// kotlin-extensions가 알아서 처리해줍니다.
// => android:id=@+id/text_name
//   -> andorid:id=@+id/nameTextView
// => android:id=@+id/btn_hello
//   -> android:id=@+id/helloButton
//  코드에서 쓸 수 있는 이름을 정확하게 지정해야 합니다.

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nextButton.setOnClickListener {
            nameTextView.text = "Hello, Android"
        }


//        val nextButton = findViewById<Button>(R.id.button_next)

        // 익명의 클래스보다 람다가 편리한 이유?
        /*
        nextButton.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View?) {
                val intent = Intent(this@MainActivity,
                        SignInActivity::class.java)

                startActivity(intent)
            }
        })
        */

//        nextButton.setOnClickListener {
//            val intent = Intent(this, SignInActivity::class.java)
//            startActivity(intent)
//        }

    }
}








