package com.example.newsapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(var newsarraylist:ArrayList<News>, var context:Activity) :
RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

   private lateinit var myListener:onItemClickListener
    interface onItemClickListener {

        fun onItemClick(position :Int)
    }

    fun setItemClickLitener(Listener: onItemClickListener){

        myListener = Listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.eachrow, parent, false)

        return MyViewHolder(itemView,myListener)

    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {

        var currentIem = newsarraylist[position]

        holder.hTitle.text = currentIem.newsHeading
        holder.hImage.setImageResource(currentIem.newsImage)
    }

    override fun getItemCount(): Int {

//        how many list items present in your arrayy
        return newsarraylist.size
    }
    class MyViewHolder(itemview:View, Listener:onItemClickListener) : RecyclerView.ViewHolder(itemview) {
        val hTitle = itemview.findViewById<TextView>(R.id.tVNewsHeading)

        val hImage = itemview.findViewById<ShapeableImageView>(R.id.newsImgae)

//        first call
        init {

            itemview.setOnClickListener {

                Listener.onItemClick(adapterPosition)
            }
        }
    }
}