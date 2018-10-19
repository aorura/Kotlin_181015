package xyz.ourguide.github.net

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.util.Log
import com.google.gson.annotations.SerializedName
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import java.util.*

data class AccessTokenBody(
    @field:SerializedName("client_id") val clientId: String,
    @field:SerializedName("client_secret") val clientSecret: String,
    val code: String
)

data class GithubAccessToken(
    @field:SerializedName("access_token") val accessToken: String,
    @field:SerializedName("token_type") val tokenType: String
) {
    companion object {
        const val ACCESS_TOKEN_KEY = "xyz.ourguide.github.access_token"

        fun load(context: Context): String? =
            PreferenceManager.getDefaultSharedPreferences(context)
                .getString(ACCESS_TOKEN_KEY, null)
    }

    fun save(context: Context) {
//        val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
//        editor.putString(ACCESS_TOKEN_KEY, accessToken)
//        editor.apply()

        PreferenceManager.getDefaultSharedPreferences(context)
            .edit()
            .putString(ACCESS_TOKEN_KEY, accessToken)
            .apply()
    }
}

data class GithubUser(
    val login: String,
    val id: Int,
    @field:SerializedName("avatar_url") val avatarUrl: String,
    val type: String,
    val name: String,
    val location: String,
    val email: String,
    val company: String?,
    val bio: String?,
    @field:SerializedName("public_repos") val publicRepos: Int,
    val followers: Int,
    val following: Int,
    @field:SerializedName("created_at") val createdAt: Date,
    @field:SerializedName("updated_at") val updatedAt: Date
)

// github.com
interface AuthApi {
    @POST("login/oauth/access_token")
    @Headers(
        "Content-Type: application/json",
        "Accept: application/json"
    )
    fun postAccessToken(@Body body: AccessTokenBody): Call<GithubAccessToken>
}

// api.github.com
interface GithubApi {
    @GET("user")
    fun getUser(): Call<GithubUser>
}

private val httpClient: OkHttpClient = OkHttpClient.Builder().apply {
    addInterceptor(HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    })
}.build()

val authApi: AuthApi = Retrofit.Builder().apply {
    baseUrl("https://github.com/")
    client(httpClient)
    addConverterFactory(GsonConverterFactory.create())
}.build().create(AuthApi::class.java)


/*
val githubApi: GithubApi = Retrofit.Builder().apply {
    baseUrl("https://api.github.com/")
    client(OkHttpClient.Builder().apply {
        addInterceptor(AuthInterceptor())
    }.build())
    addConverterFactory(GsonConverterFactory.create())
}.build().create(GithubApi::class.java)
*/

fun provideGithubApi(context: Context): GithubApi = Retrofit.Builder().apply {
    baseUrl("https://api.github.com/")
    client(OkHttpClient.Builder().apply {
        addInterceptor(AuthInterceptor(context))
    }.build())
    addConverterFactory(GsonConverterFactory.create())
}.build().create(GithubApi::class.java)

class AuthInterceptor(val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        Log.i("AuthInterceptor", "intercept")
        val original = chain.request()

        val request = original.newBuilder().apply {
            val token = GithubAccessToken.load(context)
            addHeader("Authorization", "bearer $token")
        }.build()

        return chain.proceed(request)
    }
}



















