package com.yusufmendes.recipeapp.util

import android.view.View
import android.widget.LinearLayout
import com.google.android.material.snackbar.Snackbar
import com.yusufmendes.recipeapp.R

fun View.successShowSnackbar(message: String) {

    val snackbar =
        Snackbar.make(this, message, Snackbar.LENGTH_SHORT)
    snackbar.setBackgroundTint(resources.getColor(R.color.green))
    snackbar.setTextColor(resources.getColor(R.color.white))

    val view: View = snackbar.view
    //snackbar'ın location'ı ayarlandı
    val linearParams = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
    )
    linearParams.setMargins(0, 0, 0, 0)
    view.layoutParams = linearParams
    snackbar.show()
}

fun View.failShowSnackbar(message: String) {

    val snackbar =
        Snackbar.make(this, message, Snackbar.LENGTH_SHORT)
    snackbar.setBackgroundTint(resources.getColor(R.color.red))
    snackbar.setTextColor(resources.getColor(R.color.white))

    val view: View = snackbar.view
    //snackbar'ın location'ı ayarlandı
    val linearParams = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
    )
    linearParams.setMargins(0, 0, 0, 0)
    view.layoutParams = linearParams
    snackbar.show()
}