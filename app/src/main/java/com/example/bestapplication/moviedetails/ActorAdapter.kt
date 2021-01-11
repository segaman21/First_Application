package com.example.bestapplication.moviedetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bestapplication.R
import com.example.bestapplication.data.Actor

class ActorAdapter : RecyclerView.Adapter<ActorViewHolder>(){
    val actorList =
        mutableListOf<Actor>()

    fun setItems (items: List<Actor>){
        actorList.clear()
        actorList.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
       val view = LayoutInflater.from(parent.context)
        .inflate(R.layout.view_holder_actor,parent,false)
       return ActorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
      val item = actorList[position]
      holder.onBind(item)
    }
    override fun getItemCount(): Int {
     return actorList.size
    }

}
