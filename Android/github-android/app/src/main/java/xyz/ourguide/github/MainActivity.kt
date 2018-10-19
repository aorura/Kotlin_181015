package xyz.ourguide.github

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import kotlinx.android.synthetic.main.activity_main.*
import xyz.ourguide.github.net.GithubUser
import xyz.ourguide.github.net.provideGithubApi

// glide library
//  => 안드로이드에서 이미지를 처리하는 가장 좋은 방법

class MainActivity : AppCompatActivity() {
    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }

    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // getUser()
        // 아래의 요청은 Authorization이 필요합니다.
        //  : 저장되어 있는 AccessToken을 헤더에 포함을 해주어야 합니다.
        provideGithubApi(this).getUser().enqueue {
            it.body()?.let { user ->
                Log.i(TAG, "user: $user")

                /*
                handler.post {
                    setupUi(user)
                }
                */

                setupUi(user)
            }
        }
    }

    // OkHttp는 비동기의 핸들러가 main thread에서 수행되도록 보장합니다.
    // 아래의 함수는 반드시 Ui thread 에서 수행되어야 합니다.
    private fun setupUi(user: GithubUser) {
        nameTextView.text = user.name
        emailTextView.text = user.email
        loginTextView.text = user.login

        GlideApp
            .with(this)
            .load(user.avatarUrl)
            .into(avatarImageView)

    }

}

// * 만약 의존하는 모듈이 annotation processor를 사용하고 있다면,
//   코틀린은 설정 방법이 조금 다릅니다.

// Glide 4를 사용하기 위해서는 반드시 아래의 코드가 필요합니다.
@GlideModule
class MyAppGlideModule : AppGlideModule()
















