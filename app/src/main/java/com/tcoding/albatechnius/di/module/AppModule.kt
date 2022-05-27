package com.tcoding.albatechnius.di.module

import com.tcoding.albatechnius.di.retrofit.RetrofitServiceInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    var baseUrl = "https://frosty-lewin.5-9-253-136.plesk.page/"

    @Provides
    @Singleton
    fun getRetrofitServiceInstance(retrofit : Retrofit) : RetrofitServiceInstance
    {
        return retrofit.create(RetrofitServiceInstance::class.java)
    }

    @Singleton
    @Provides
    fun getRetroInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }


}