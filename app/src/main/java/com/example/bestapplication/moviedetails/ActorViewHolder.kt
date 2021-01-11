package com.example.bestapplication.moviedetails

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.bestapplication.R
import com.example.bestapplication.data.Actor


class ActorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun onBind(item: Actor) {
        val nameActor = itemView.findViewById<TextView>(R.id.name_actor)
        val photoActor = itemView.findViewById<ImageView>(R.id.imageView_ironman)

        nameActor.text = item.name
        val imageUrl = item.picture
        Glide.with(itemView)
                .load(imageUrl)
                .placeholder(R.drawable.arrow)
                .centerCrop()
                .into(photoActor)
    }
}
