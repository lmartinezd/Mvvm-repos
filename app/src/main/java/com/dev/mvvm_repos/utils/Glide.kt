package com.dev.mvvm_repos.utils

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions


fun ImageView.loadImage(
    url: String?,
    @DrawableRes errorPlaceHolder: Int
) {
    url?.let {
        val options = RequestOptions().apply {
            fitCenter()
        }
        Glide
            .with(this)
            .load(it)
            .error(errorPlaceHolder)
            .apply(options)
            .into(this)
    }
}

fun ImageView.loadImageWithCornerRadius(
    url: String,
    cornerRadius: Int,
    @DrawableRes errorPlaceHolder: Int
) {
    Glide.with(this)
        .load(url)
        .error(errorPlaceHolder)
        .fallback(errorPlaceHolder)
        .transform(RoundedCorners(cornerRadius))
        .into(this)
}