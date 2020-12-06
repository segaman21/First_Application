package com.example.bestapplication

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class actorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val name_actor= itemView.findViewById<TextView>(R.id.name_actor)
    val photo_actor= itemView.findViewById<ImageView>(R.id.imageView_ironman)
}
