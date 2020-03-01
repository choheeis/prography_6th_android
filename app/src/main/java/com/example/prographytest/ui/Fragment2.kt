package com.example.prographytest.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prographytest.data.DataDefine
import com.example.prographytest.R
import com.example.prographytest.server.ServerImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Fragment2 : Fragment() {

    private lateinit var myRecyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: Adapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chats, container, false)

        // 리사이클러뷰 초기 세팅
        myRecyclerView = view.findViewById(R.id.recyclerView)
        recyclerViewAdapter = Adapter(activity!!)
        myRecyclerView.adapter = recyclerViewAdapter
        myRecyclerView.layoutManager = LinearLayoutManager(activity!!)

        /** 영화 목록 리스트 서버 통신 요청 */
        val call: Call<List<DataDefine>> = ServerImpl.service.requestFilmsList()
        call.enqueue(
            object : Callback<List<DataDefine>>{
                override fun onFailure(call: Call<List<DataDefine>>, t: Throwable) {
                    Log.e("server_test", "fail")
                }

                override fun onResponse(
                    call: Call<List<DataDefine>>,
                    response: Response<List<DataDefine>>
                ) {
                    recyclerViewAdapter.data = response.body()!!
                    recyclerViewAdapter.notifyDataSetChanged()
                }

            }
        )
        return view
    }

}