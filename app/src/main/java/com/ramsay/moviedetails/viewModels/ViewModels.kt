package com.ramsay.moviedetails.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.load.engine.Resource
import com.ramsay.moviedetails.models.response.ResponseDTO
import com.ramsay.moviedetails.repository.repo
import kotlinx.coroutines.launch

class ViewModels : ViewModel(){
    private val repo = repo()

    private val response = MutableLiveData<ResponseDTO>()
    val liveData : LiveData<ResponseDTO>
        get() = response

    init {
        getData()

    }

    private fun getData() = viewModelScope.launch {

        repo.getData().let {
            response.postValue(it.body())

        }


    }
}