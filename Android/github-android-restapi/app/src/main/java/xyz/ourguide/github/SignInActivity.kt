package xyz.ourguide.github

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.util.Log
import kotlinx.android.synthetic.main.activity_sign_in.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import xyz.ourguide.github.net.AccessTokenBody
import xyz.ourguide.github.net.GithubAccessToken
import xyz.ourguide.github.net.authApi

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

        val call: Call<GithubAccessToken> = authApi.postAccessToken(
            AccessTokenBody(
                clientId = CLIENT_ID,
                clientSecret = CLIENT_SECRET,
                code = code
            )
        )

        call.enqueue { response ->
            val token = response.body()
            token?.save(this)

            startActivity<MainActivity>()
        }

        // 동기
        //  : Main Thread에서는 절대 호출할 수 없습니다.
        // val response = call.execute()

        // 비동기
        // Access Token을 응답으로 받아서, 저장해야 합니다.
        //  => Shared Preference
        /*
        call.enqueue(object : Callback<GithubAccessToken> {
            override fun onFailure(call: Call<GithubAccessToken>, t: Throwable) {

            }

            override fun onResponse(call: Call<GithubAccessToken>, response: Response<GithubAccessToken>) {
                val token = response.body()
                token?.save(this@SignInActivity)
            }
        })
        */


        // Retrofit Call
        //  OkHttp  Call + Converter factory(JSON, Protobuf)


        // de2cdf1a7070cf1c8936
        // POST
        //   https://github.com/login/oauth/access_token
        //   Body - JSON
        //   { "client_id": "", "client_secret": "", "code": "" }

        // Retrofit, OkHttp, Gson
        //  OKHttp - Http Client Library
        //  : 비동기 기반 라이브러리
        //  => 동기, 비동기 호출 방식을 사용자가 제어할 수 있다.

        //  Retrofit
        //   : REST API 구현을 할 때 반복되는 코드
        //   Okhttp API Call
        //    -> 응답 (JSON)
        //    -> 모델 객체로 변환 (Gson)
        //  위의 과정을 어노테이션 기반으로 자동으로 구현되도록
        //  하는 라이브러리

        // 동기: 요청하면, 결과가 반환된다.
        // 비동기: 요청하면, 결과를 이후에 처리해야 한다.
        //   => Callback을 등록해서 결과를 처리한다.

    }
}

fun <T> Call<T>.enqueue(
    success: (response: Response<T>) -> Unit,
    failure: ((t: Throwable) -> Unit)?
) {
    enqueue(object : Callback<T> {
        override fun onFailure(call: Call<T>, t: Throwable) {
            failure?.invoke(t)
        }

        override fun onResponse(call: Call<T>, response: Response<T>) {
            success(response)
        }
    })
}

fun <T> Call<T>.enqueue(success: (response: Response<T>) -> Unit) {
    this.enqueue(success, null)
}

































