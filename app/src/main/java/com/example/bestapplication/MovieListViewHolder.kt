package com.example.bestapplication

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class MovieListViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    val title = itemView.findViewById<TextView>(R.id.movie_name)
    val time = itemView.findViewById<TextView>(R.id.time)
    val tv_age = itemView.findViewById<TextView>(R.id.tv_age)
    val isliked = itemView.findViewById<ImageView>(R.id.isliked)
    val poster = itemView.findViewById<ImageView>(R.id.ImageView_mask)
    val genere = itemView.findViewById<TextView>(R.id.genere)
    val reviews = itemView.findViewById<TextView>(R.id.how_reviews)
    val first_star = itemView.findViewById<ImageView>(R.id.first_star)
    val second_star = itemView.findViewById<ImageView>(R.id.second_star)
    val thrid_star = itemView.findViewById<ImageView>(R.id.thrid_star)
    val four_star = itemView.findViewById<ImageView>(R.id.four_star)
    val five_star = itemView.findViewById<ImageView>(R.id.five_star)
    fun setRate(rate: Int) {
        when (rate) {
            1 -> {
                first_star.setImageDrawable(
                        ContextCompat.getDrawable(
                                itemView.context,
                                R.drawable.star_red
                        )
                )
                second_star.setImageDrawable(
                        ContextCompat.getDrawable(
                                itemView.context,
                                R.drawable.star_gray
                        )
                )
                thrid_star.setImageDrawable(
                        ContextCompat.getDrawable(
                                itemView.context,
                                R.drawable.star_gray
                        )
                )
                four_star.setImageDrawable(
                        ContextCompat.getDrawable(
                                itemView.context,
                                R.drawable.star_gray
                        )
                )
                five_star.setImageDrawable(
                        ContextCompat.getDrawable(
                                itemView.context,
                                R.drawable.star_gray
                        )
                )

            }
            2 -> {
                first_star.setImageDrawable(
                        ContextCompat.getDrawable(
                                itemView.context,
                                R.drawable.star_red
                        )
                )
                second_star.setImageDrawable(
                        ContextCompat.getDrawable(
                                itemView.context,
                                R.drawable.star_red
                        )
                )
                thrid_star.setImageDrawable(
                        ContextCompat.getDrawable(
                                itemView.context,
                                R.drawable.star_gray
                        )
                )
                four_star.setImageDrawable(
                        ContextCompat.getDrawable(
                                itemView.context,
                                R.drawable.star_gray
                        )
                )
                five_star.setImageDrawable(
                        ContextCompat.getDrawable(
                                itemView.context,
                                R.drawable.star_gray
                        )
                )
            }
            3 -> {
                first_star.setImageDrawable(
                        ContextCompat.getDrawable(
                                itemView.context,
                                R.drawable.star_red
                        )
                )
                second_star.setImageDrawable(
                        ContextCompat.getDrawable(
                                itemView.context,
                                R.drawable.star_red
                        )
                )
                thrid_star.setImageDrawable(
                        ContextCompat.getDrawable(
                                itemView.context,
                                R.drawable.star_red
                        )
                )
                four_star.setImageDrawable(
                        ContextCompat.getDrawable(
                                itemView.context,
                                R.drawable.star_gray
                        )
                )
                five_star.setImageDrawable(
                        ContextCompat.getDrawable(
                                itemView.context,
                                R.drawable.star_gray
                        )
                )
            }
            4 -> {
                first_star.setImageDrawable(
                        ContextCompat.getDrawable(
                                itemView.context,
                                R.drawable.star_red
                        )
                )
                second_star.setImageDrawable(
                        ContextCompat.getDrawable(
                                itemView.context,
                                R.drawable.star_red
                        )
                )
                thrid_star.setImageDrawable(
                        ContextCompat.getDrawable(
                                itemView.context,
                                R.drawable.star_red
                        )
                )
                four_star.setImageDrawable(
                        ContextCompat.getDrawable(
                                itemView.context,
                                R.drawable.star_red
                        )
                )
                five_star.setImageDrawable(
                        ContextCompat.getDrawable(
                                itemView.context,
                                R.drawable.star_gray
                        )
                )
            }
            5 -> {
                first_star.setImageDrawable(
                        ContextCompat.getDrawable(
                                itemView.context,
                                R.drawable.star_red
                        )
                )
                second_star.setImageDrawable(
                        ContextCompat.getDrawable(
                                itemView.context,
                                R.drawable.star_red
                        )
                )
                thrid_star.setImageDrawable(
                        ContextCompat.getDrawable(
                                itemView.context,
                                R.drawable.star_red
                        )
                )
                four_star.setImageDrawable(
                        ContextCompat.getDrawable(
                                itemView.context,
                                R.drawable.star_red
                        )
                )
                five_star.setImageDrawable(
                        ContextCompat.getDrawable(
                                itemView.context,
                                R.drawable.star_red
                        )
                )
            }
            else -> throw IllegalStateException("Illegal rating value")
        }
    }
}

