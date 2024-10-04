package com.callcenter.dicodingpemula

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ArticleAdapter(
    private val articles: List<Article>,
    private val onItemClicked: (Article) -> Unit
) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val overviewTextView: TextView = itemView.findViewById(R.id.overviewTextView)
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)

        fun bind(article: Article) {
            titleTextView.text = article.title
            overviewTextView.text = article.overview
            imageView.setImageURI(android.net.Uri.parse(article.imageUri))

            itemView.setOnClickListener { onItemClicked(article) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(articles[position])
    }

    override fun getItemCount(): Int = articles.size
}
