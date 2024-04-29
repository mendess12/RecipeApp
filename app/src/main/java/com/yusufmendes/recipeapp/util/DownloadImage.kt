package com.yusufmendes.recipeapp.util

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.downloadImage(url: String) {
    Glide.with(this).load(url).into(this)
}