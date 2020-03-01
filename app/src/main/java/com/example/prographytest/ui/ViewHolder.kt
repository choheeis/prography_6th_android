package com.example.prographytest.ui

import android.view.View
import android.widget.TextView
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
    }
}