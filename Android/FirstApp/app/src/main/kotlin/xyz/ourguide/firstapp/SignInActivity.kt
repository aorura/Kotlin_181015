package xyz.ourguide.firstapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

// 1. Activity Source 추가
// 2. AndroidManifest.xml 등록
// 3. Layout 파일 추가

// AppCompatActivity
class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
    }
}
