package com.example.bestapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bestapplication.data.Actor

class ActorAdapter : RecyclerView.Adapter<actorViewHolder>(){
    val actorList =
        mutableListOf<Actor>()

    fun setItems (items: MutableList<Actor>){
        actorList.clear()
        actorList.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): actorViewHolder {
       val view = LayoutInflater.from(parent.context)
        .inflate(R.layout.view_holder_actor,parent,false)
       return actorViewHolder(view)
    }

    override fun onBindViewHolder(holder: actorViewHolder, position: Int) {
      val item = actorList[position]
      holder.name_actor.text= item.name
      Glide
              .with(holder.itemView)
              .load(item.picture)
              .centerCrop()
              .into(holder.photo_actor)
    }
    override fun getItemCount(): Int {
     return actorList.size
    }

}
