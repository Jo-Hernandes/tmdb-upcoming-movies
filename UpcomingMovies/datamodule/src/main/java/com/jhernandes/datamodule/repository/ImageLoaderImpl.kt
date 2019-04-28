package com.jhernandes.datamodule.repository

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

class ImageLoaderImpl (private val context: Context) : ImageLoader {

    companion object {
        const val thumbnailMultiplier = 0.1f
        const val fullSizeMultiplier  = 1.0f
    }

    override fun loadImageInto(view: ImageView, url : String, isThumbnail : Boolean) {
        Glide.with(context)
            .load(url)
            .centerCrop()
            .thumbnail(if (isThumbnail) thumbnailMultiplier else fullSizeMultiplier)
            .into(view)
    }

}