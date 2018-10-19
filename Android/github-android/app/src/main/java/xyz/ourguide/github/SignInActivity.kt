package xyz.ourguide.github

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

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

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
    }
}
