package com.example.workers

import com.example.workers.model.Response
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface API {
    @GET("testTask.json/")
    fun getData(): Call<Response>
}

object ApiUtils {

    private const val BASE_URL = "https://gitlab.65apps.com/65gb/static/raw/master/"

    val apiService: API
        get() = RetrofitClient.getClient(BASE_URL)!!.create(API::class.java)
}

object RetrofitClient {
    var retrofit: Retrofit? = null

    fun getClient(baseUrl: String): Retrofit? {
        if (retrofit == null) {

//            val interceptor = HttpLoggingInterceptor()
//            if (BuildConfig.DEBUG) {
//                interceptor.level = HttpLoggingInterceptor.Level.BODY
//            }

            val client = OkHttpClient.Builder()
//                .addInterceptor(interceptor)
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS)
                .build()

            retrofit = Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()
        }

        return retrofit!!
    }
}