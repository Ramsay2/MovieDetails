package com.ramsay.moviedetails.models

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiHelper {
    companion object {


        fun instance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(DataApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().build())
                .build()
        }
    }
}
