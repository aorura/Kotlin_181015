package xyz.ourguide.firstapp

import android.content.Intent
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

// Kotlin - DSL(Domain Specific Language)
//   : 도메인 특화 언어
//  => Anko 라이브러리를 이용하면, 안드로이드에서 반복되는 수많은 코드를
//     간결하게 사용할 수 있습니다.

// Anko
//   : Jetbrains 에서 직접 제작하여 배포하는 안드로이드 DSL 라이브러리
// 1) Anko Commons
// 2) Anko Layout
// 3) Anko SQLite
// 4) Anko Coroutine
//   : 비동기의 호출을 처리하는 기술 표준: 'Rx'

//   Kotlin 1.2
//    Coroutine - Experimental
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nextButton.setOnClickListener {
            nameTextView.text = "Hello, Android"

            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
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








