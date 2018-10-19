package xyz.ourguide.github.net

import com.google.gson.annotations.SerializedName
import okhttp3.OkHttpClient
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
)

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
























