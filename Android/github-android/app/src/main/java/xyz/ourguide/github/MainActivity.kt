package xyz.ourguide.github

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import xyz.ourguide.github.net.provideGithubApi

class MainActivity : AppCompatActivity() {
    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // getUser()
        // 아래의 요청은 Authorization이 필요합니다.
        //  : 저장되어 있는 AccessToken을 헤더에 포함을 해주어야 합니다.
        provideGithubApi(this).getUser().enqueue {
            it.body()?.let { user ->
                Log.i(TAG, "user: $user")
            }
        }
    }
}