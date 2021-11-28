package com.ramsay.moviedetails.models

import com.ramsay.moviedetails.models.response.ResponseDTO
import retrofit2.Response
import retrofit2.http.GET

interface DataApi {
    companion object {
        const val BASE_URL = "https://api.themoviedb.org/"
    }
    @GET("/3/movie/popular?api_key=f376e95f9ee4786be13cb48ea6361b53")
    suspend fun getMovie(): Response<ResponseDTO>

}