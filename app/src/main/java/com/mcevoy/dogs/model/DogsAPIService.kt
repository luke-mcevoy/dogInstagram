package com.mcevoy.dogs.model

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class DogsAPIService {

    private val BASE_URL = "https://raw.githubusercontent.com"

    private val API = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(DogsAPI::class.java)

    fun getDogs(): Single<List<DogBreed>> {
        return API.getDogs()
    }
}