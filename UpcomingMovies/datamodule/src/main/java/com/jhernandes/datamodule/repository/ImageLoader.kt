package com.jhernandes.datamodule.repository

import android.widget.ImageView

interface ImageLoader {

    fun loadImageInto(view: ImageView, url : String, isThumbnail : Boolean = false)
}