package com.zncm.jmxandroid.mykotlin

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.zncm.jmxandroid.R
import com.zncm.jmxandroid.base.BaseAc
import kotlinx.android.synthetic.main.activity_ktlistview.*
import java.util.ArrayList

/**
 * Created by jiaomx on 2017/5/19.
 */
class MyKotlinListView : BaseAc() {
    override fun getLayoutResource(): Int {
        return R.layout.activity_ktlistview
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        var datas = ArrayList<String>()
        for (i in 1..50){
            datas.add(i.toString())
        }
        var adapter: RecyclerViewAdapter=RecyclerViewAdapter(datas)

        recyclerView.adapter = adapter

    }

}

 class RecyclerViewAdapter(var data: MutableList<String>) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHoder>() {
    override fun onBindViewHolder(recyclerViewHoder: RecyclerViewHoder, i: Int) {
        recyclerViewHoder.textView.setText(data.get(i))


    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): RecyclerViewHoder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.activity_item, viewGroup, false)
        val holder = RecyclerViewHoder(view)
        return holder

    }

    override fun getItemCount(): Int {
       return data.size
    }


     class RecyclerViewHoder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         var textView: TextView
        init {
            textView = itemView.findViewById(R.id.textView) as TextView
        }
    }

}
