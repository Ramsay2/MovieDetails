package com.ramsay.moviedetails.models

import com.ramsay.moviedetails.models.response.ResponseDTO
import retrofit2.Response
import retrofit2.http.GET

interface DataApi {
    companion object {
        const val BASE_URL = "https://api.themoviedb.org/"
    }
    @GET("/3/discover/movie?api_key=328c283cd27bd1877d9080ccb1604c91&primary_release_date.lte=2021-12-31&sort_by=release_date.desc&page=2")
    suspend fun getMovie(): Response<ResponseDTO>

}