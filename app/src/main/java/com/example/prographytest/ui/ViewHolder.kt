package com.example.prographytest.ui

import android.content.Intent
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.prographytest.data.DataDefine
import com.example.prographytest.R

class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val position: TextView = itemView.findViewById(R.id.position)
    val title: TextView = itemView.findViewById(R.id.title)
    val director: TextView = itemView.findViewById(R.id.director)
    val release_date: TextView = itemView.findViewById(R.id.release_date)

    fun bind(data: DataDefine){
        position.text = (adapterPosition + 1).toString()
        title.text = data.title
        director.text = "영화감독 : " + data.director
        release_date.text = "출시년도 : " + data.release_date

        itemView.setOnClickListener {
            val intent = Intent(itemView.context, DetailActivity::class.java)
            intent.putExtra("title", data.title)
            intent.putExtra("director", data.director)
            intent.putExtra("release_date", data.release_date)
            intent.putExtra("description", data.description)
            intent.putExtra("producer", data.producer)
            intent.putExtra("rt_score", data.rt_score)
            itemView.context.startActivity(intent)
        }
    }
}