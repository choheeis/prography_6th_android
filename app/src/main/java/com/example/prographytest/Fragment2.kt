package com.example.prographytest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Fragment2 : Fragment() {

    private lateinit var myRecyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: Adapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chats, container, false)
        myRecyclerView = view.findViewById(R.id.recyclerView)
        recyclerViewAdapter = Adapter(activity!!)
        myRecyclerView.adapter = recyclerViewAdapter
        myRecyclerView.layoutManager = LinearLayoutManager(activity!!)
        recyclerViewAdapter.data = listOf(
            DataDefine(
                title = "dd",
                director = "봉준호1",
                release_date = "2019"
            ),
            DataDefine(
                title = "dd",
                director = "봉준호1",
                release_date = "2019"
            ),
            DataDefine(
                title = "dd",
                director = "봉준호1",
                release_date = "2019"
            ),DataDefine(
                title = "dd",
                director = "봉준호1",
                release_date = "2019"
            ),
            DataDefine(
                title = "dd",
                director = "봉준호1",
                release_date = "2019"
            ),
            DataDefine(
                title = "dd",
                director = "봉준호1",
                release_date = "2019"
            ),DataDefine(
                title = "dd",
                director = "봉준호1",
                release_date = "2019"
            ),DataDefine(
                title = "dd",
                director = "봉준호1",
                release_date = "2019"
            )
        )
        recyclerViewAdapter.notifyDataSetChanged()
        return view
    }

}