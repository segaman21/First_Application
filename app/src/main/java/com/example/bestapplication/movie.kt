package com.example.bestapplication

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Movie(
        val title: String,
        val genre: String,
        var reviews: Int,
        var rate: Int,
        val duration: Int,
        val ageRate: Int,
        var isLiked: Boolean = false,
        @DrawableRes val posterImage: Int)
data class Actor(
         val name_actor: String,
        @DrawableRes val actorImage: Int)