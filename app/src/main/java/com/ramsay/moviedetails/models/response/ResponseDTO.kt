package com.ramsay.moviedetails.models.response


import com.google.gson.annotations.SerializedName
import com.ramsay.moviedetails.models.response.Result

data class ResponseDTO(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    var results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)