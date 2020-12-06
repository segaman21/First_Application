package com.example.bestapplication

import android.view.LayoutInflater
import android.view.View.inflate
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ActorAdapter : RecyclerView.Adapter<actorViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): actorViewHolder {
       val view = LayoutInflater.from(parent.context)
        .inflate(R.layout.view_holder_actor,parent,false)
       return actorViewHolder(view)
    }
    override fun onBindViewHolder(holder: actorViewHolder, position: Int) {
      val item = actorList[position]
      holder.name_actor.text= item.name_actor
      holder.photo_actor.setImageDrawable(
          ContextCompat.getDrawable(
          holder.itemView.context,
          item.actorImage)
      )
    }
    override fun getItemCount(): Int {
     return actorList.size
    }
}
   val actorList =
       mutableListOf(
        Actor ("Robert Downey Jr.", R.drawable.ironman),
        Actor ("Chris Evans", R.drawable.america),
        Actor ("Mark Ruffalo", R.drawable.hulk),
        Actor ("Chris Hemsworth", R.drawable.thor),
   )