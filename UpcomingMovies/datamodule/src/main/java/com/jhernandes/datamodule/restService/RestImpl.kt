package com.jhernandes.datamodule.restService

class RestImpl : RestInterface {

    override fun provideWebService(): WebService = WebClient().getClient().create(WebService::class.java)
}