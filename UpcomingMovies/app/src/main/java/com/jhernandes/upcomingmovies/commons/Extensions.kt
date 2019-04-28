package com.jhernandes.upcomingmovies.commons

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.jhernandes.datamodule.ServiceModule
import java.text.SimpleDateFormat
import java.util.Locale

private var baseDateFormat = "yyyy-MM-dd"
private var readableFormat = "MM-dd-yyyy"


@BindingAdapter("thumbnailUrl")
fun ImageView.setThumbnail(url: String) {
    ServiceModule().getImageService(this.context).loadImageInto(this, url, true)
}

@BindingAdapter("imageUrl")
fun ImageView.setImage(url: String) {
    ServiceModule().getImageService(this.context).loadImageInto(this, url)
}

@BindingAdapter("readableDate")
fun TextView.setDateFormatted(date : String) {
    val tempDate = SimpleDateFormat(baseDateFormat, Locale.getDefault()).parse(date)
    this.text = SimpleDateFormat(readableFormat, Locale.getDefault()).format(tempDate)
}