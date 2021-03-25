package com.rogergcc.retorgcprojectmdevconf2020.ui.utils

import android.content.Context
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions


/**
 * Created by rogergcc on 24/03/2021.
 * Copyright Ⓒ 2021 . All rights reserved.
 */

fun loadImageDrawableFromUrl(context: Context, urlPhoto: String, targetView: ImageView) {
    Glide.with(context)
        .asBitmap()
        .apply(RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
        .apply(RequestOptions().override(100))
        .load(urlPhoto)
        .into(targetView)
}

fun loadImageFromDrawable(context: Context, @DrawableRes resId: Int, targetView: ImageView) {
    Glide.with(context)
        .asBitmap()
        .apply(RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
        .apply(RequestOptions().override(100))
        .load(resId)
        .into(targetView)
}
