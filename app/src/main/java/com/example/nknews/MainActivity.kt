package com.example.nknews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback


//API Key=402b2cf7806a4b8baaa84e440fc9ede0
class MainActivity : AppCompatActivity() {
    lateinit var adapter:MAdapter
    private var articles = mutableListOf<Article>()
    var pagenum=1
    var totalResults=-1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter=MAdapter(this@MainActivity,articles)

        newsList.adapter=adapter
        newsList.layoutManager=LinearLayoutManager(this@MainActivity)


        getNews()









//
//        val songs= listOf<String>("Hello","ABCD","HEllp2","Tere Naam")
//
//        val songsObjects= mutableListOf<Song>()
//        songsObjects.add(Song("Hello","Desc"))
//        songsObjects.add(Song("Hello","Desc"))
//        songsObjects.add(Song("Hello","Desc"))
//        songsObjects.add(Song("Hello","Desc"))
//        songsObjects.add(Song("Hello","Desc"))
//        songsObjects.add(Song("Hello","Desc"))
//        songsObjects.add(Song("Hello","Desc"))
//        songsObjects.add(Song("Hello","Desc"))
//
//
//        songList.adapter=MAdapter(songsObjects)
//        songList.layoutManager=LinearLayoutManager(this)
    }

    private fun getNews() {
        val news = NkInterface.newsInstance.getHeadlines("in",pagenum)

        news.enqueue(object : retrofit2.Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {

                val news= response.body()
                if (news!=null){
                    totalResults=news.totalResults
                    Log.d("yaha mai pighal gaya",news.toString())
                    articles.addAll(news.articles)
                    adapter.notifyDataSetChanged()

                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("Yaha mai pighal gaya","Error in Fetching News",t)
            }
        })
    }
}