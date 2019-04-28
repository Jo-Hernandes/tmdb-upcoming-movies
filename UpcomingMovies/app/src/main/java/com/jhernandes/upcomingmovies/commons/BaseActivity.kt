package com.jhernandes.upcomingmovies.commons

import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.jhernandes.upcomingmovies.R
import org.jetbrains.anko.progressDialog
import org.jetbrains.anko.toast

abstract class BaseActivity : AppCompatActivity() {

    fun showProgress (@StringRes stringRes: Int) =
        progressDialog(title = R.string.progress_please_wait_text, message = stringRes)

    fun showToast (@StringRes stringRes: Int) =
        toast(message = stringRes)

}