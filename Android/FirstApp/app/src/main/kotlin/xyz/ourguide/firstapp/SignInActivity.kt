package xyz.ourguide.firstapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sign_in.*

// Github Client
//  1. OAuth - Login
//  2. REST API
//      => OKHttp + Retrofit + Gson + Rx

// 1. Activity Source 추가
// 2. AndroidManifest.xml 등록
// 3. Layout 파일 추가

// AppCompatActivity
class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val intent: Intent? = intent
        intent?.let {
            val email: String? = it.getStringExtra("email")
            val password: String? = it.getStringExtra("password")

            emailEditText.setText(email)
            passwordEditText.setText(password)
        }
    }
}







