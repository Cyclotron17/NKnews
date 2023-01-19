package com.example.nknews

import android.icu.text.CaseMap.Title

data class Article(val author: String, val title: String, val description: String, val url:String, val urlToImage:String, val publishedAt:String) {
}