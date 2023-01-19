package com.example.nknews

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org//v2/top-headlines?apikey=402b2cf7806a4b8baaa84e440fc9ede0&country=in&page=1
const val BASE_URL="https://newsapi.org/"
const val API_KEY="402b2cf7806a4b8baaa84e440fc9ede0"
interface NkInterfac {

    @GET("/v2/top-headlines?apikey=$API_KEY")
    fun getHeadlines(@Query("country")country: String, @Query("page") page:Int) : Call<News>

    //  https://newsapi.org//v2/top-headlines?apikey=$API_KEY&country=in&page=1
}

object NkInterface {
    val newsInstance: NkInterfac

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NkInterfac::class.java)
    }
}
