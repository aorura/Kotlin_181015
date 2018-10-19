package xyz.ourguide.github.net

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

data class AccessTokenBody(
    @field:SerializedName("client_id") val clientId: String,
    @field:SerializedName("client_secret") val clientSecret: String,
    val code: String
)

data class GithubAccessToken(
    @field:SerializedName("access_token") val accessToken: String,
    @field:SerializedName("token_type") val tokenType: String
)

//   HTTP      <->   Database
//   GET              READ
//   POST             CREATE
//   PUT              UPDATE
//   DELETE           DELETE

// OkHttp
//   Call

// Retrofit
//   Call

// Retrofit 적용하기
// 1. Interface 만들기
// baseUrl("https://github.com/")
interface AuthApi {
    @POST("login/oauth/access_token")
    @Headers(
        "Content-Type: application/json",
        "Accept: application/json"
    )
    fun postAccessToken(@Body body: AccessTokenBody): Call<GithubAccessToken>
}

// {
//    "access_token": "8f21827a310bdb36b51e0e84d61b1af7040a5261",
//    "token_type": "bearer",
//    "scope": ""
// }









