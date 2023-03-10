package com.example.nknews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide

class MAdapter(val context: Context, val articles: List<Article>): RecyclerView.Adapter<MAdapter.MViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_view,parent, false)
        return MViewHolder(view)

    }

    override fun onBindViewHolder(holder: MViewHolder, position: Int) {
        var article=articles[position]

        holder.newsTitle.text=article.title
        holder.newsDescription.text=article.description

        Glide.with(context).load(article.urlToImage).into(holder.newsImage)

        holder.itemView.setOnClickListener {
            Toast.makeText(context, article.title, Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {

        return articles.size
    }

    class MViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var newsImage= itemView.findViewById<ImageView>(R.id.newsImage)
        var newsTitle= itemView.findViewById<TextView>(R.id.txtTitle)
        var newsDescription= itemView.findViewById<TextView>(R.id.txtDescrip)
    }

}

