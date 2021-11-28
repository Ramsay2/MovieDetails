package com.ramsay.moviedetails.repository

import com.ramsay.moviedetails.models.ApiHelper
import com.ramsay.moviedetails.models.DataApi

class repo {

  private var dataApi :DataApi = ApiHelper.instance().create(DataApi::class.java)

    suspend fun getData() =  dataApi.getMovie()


}