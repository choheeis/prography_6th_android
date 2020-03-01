package com.example.prographytest

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val position: TextView = itemView.findViewById(R.id.position)
    val title: TextView = itemView.findViewById(R.id.title)
    val director: TextView = itemView.findViewById(R.id.director)
    val release_date: TextView = itemView.findViewById(R.id.release_date)

    fun bind(data: DataDefine){
        title.text = data.title
        director.text = data.director
        release_date.text = data.release_date
    }
}