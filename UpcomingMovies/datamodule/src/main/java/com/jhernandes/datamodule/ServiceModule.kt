package com.jhernandes.datamodule

import android.content.Context
import com.jhernandes.datamodule.repository.ImageLoader
import com.jhernandes.datamodule.repository.ImageLoaderImpl
import com.jhernandes.datamodule.restService.RestImpl
import com.jhernandes.datamodule.restService.WebService

class ServiceModule {

    fun getRestService () : WebService = RestImpl().provideWebService()

    fun getImageService (context : Context) : ImageLoader = ImageLoaderImpl(context)

}