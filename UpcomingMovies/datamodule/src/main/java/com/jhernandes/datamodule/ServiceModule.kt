package com.jhernandes.datamodule

import android.content.Context
import com.jhernandes.datamodule.repository.DataRepository
import com.jhernandes.datamodule.repository.DataRepositoryImpl
import com.jhernandes.datamodule.repository.ImageLoader
import com.jhernandes.datamodule.repository.ImageLoaderImpl

class ServiceModule {

    fun getRestService () : DataRepository = DataRepositoryImpl()

    fun getImageService (context : Context) : ImageLoader = ImageLoaderImpl(context)

}