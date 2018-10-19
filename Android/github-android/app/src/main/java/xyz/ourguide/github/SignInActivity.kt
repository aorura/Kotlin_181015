package xyz.ourguide.github

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import kotlinx.android.synthetic.main.activity_sign_in.*
import org.jetbrains.anko.toast

// 1. Serverless
//   Firebase - Auth, Database, Storage

//  OAuth(Social Login)
//   : [Google, Facebook, Github], Naver, Kakao
//  Database
//   - Realtime Database
//   - Firestore(GCP Datastore)

// 2. REST API 연동
//   github API

// Callback: hubclient://authorize
// ClientID: b86fc618e4d1e442b8c6
// ClientSecret: f784827f1346160399520a39a57cbd5070c0ffe7

// Anko Commons 의존성을 추가하겠습니다.

class SignInActivity : AppCompatActivity() {
    companion object {
        const val CLIENT_ID = "b86fc618e4d1e442b8c6"
        const val CLIENT_SECRET = "f784827f1346160399520a39a57cbd5070c0ffe7"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        // https://github.com/login/oauth/authorize?client_id=<CLIENT_ID>
        signInButton.setOnClickListener {
            val authUri = Uri.Builder().apply {
                scheme("https")
                authority("github.com")
                appendPath("login")
                appendPath("oauth")
                appendPath("authorize")
                appendQueryParameter("client_id", CLIENT_ID)
            }.build()

            toast(authUri.toString())

            // 해당 Uri를 브라우저를 통해서 열기
            val intent = CustomTabsIntent.Builder().build()
            intent.launchUrl(this, authUri)
        }


    }
}













