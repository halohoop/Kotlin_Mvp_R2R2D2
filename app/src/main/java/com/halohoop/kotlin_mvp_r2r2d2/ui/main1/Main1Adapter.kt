package com.halohoop.kotlin_mvp_r2r2d2.ui.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.halohoop.kotlin_mvp_r2r2d2.R
import com.halohoop.kotlin_mvp_r2r2d2.data.source.User1
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by Pooholah on 2017/6/27.
 */

class Main1Adapter(val ctx: Context) : RecyclerView.Adapter<Main1Adapter.ViewHolder1>() {

    interface OnItemClickListener {
        fun onItemClick(user: User1)
    }

    var onItemClick: OnItemClickListener? = null
        set(value) {
            field = value
        }

    private val data: ArrayList<User1> = arrayListOf()

    fun notifyDataSetChanged(data: List<User1>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()//调用原有的
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder1?, position: Int) {
        val user = data[position]
        Glide.with(ctx).load(user.avatar_url).into(holder?.user_avatar)
        holder?.user_name?.text = user.name
        holder?.itemView?.onClick {
            onItemClick?.onItemClick(user)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder1 {
        val itemView = LayoutInflater.from(ctx).inflate(R.layout.adapter1_big_user_item, parent, false)
        return ViewHolder1(itemView)
    }


    class ViewHolder1(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val user_avatar: ImageView = itemView.find(R.id.user_avatar)
        val user_name: TextView = itemView.find(R.id.user_name)
    }
}