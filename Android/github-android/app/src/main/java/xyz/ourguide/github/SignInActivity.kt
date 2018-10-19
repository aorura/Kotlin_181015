package xyz.ourguide.github

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.util.Log
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
        // const val TAG = "SignInActivity"
        val TAG: String = SignInActivity::class.java.simpleName

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

            // toast(authUri.toString())

            // 해당 Uri를 브라우저를 통해서 열기
            val intent = CustomTabsIntent.Builder().build()
            intent.launchUrl(this, authUri)

            // 브라우저에서 로그인에 성공하면, hubclient://authorize 로 이동합니다.
            // => AndroidManifest.xml 에 해당 정보를 추가해야 합니다.
            // => launchMode를 singleTask로 지정해야 합니다.
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        // toast("OnNewIntent")

        val code = intent?.data?.getQueryParameter("code")
        if (code == null) {
            toast("code가 존재하지 않습니다.")
            return;
        }

        // code 를 이용해서, github API 서버로부터 AccessToken을 받아 와야 합니다.
        Log.i(TAG, code)
    }
}













