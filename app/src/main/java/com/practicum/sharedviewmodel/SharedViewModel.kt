package com.practicum.sharedviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val mutableLiveData = MutableLiveData<String>()
    val data : LiveData<String> = mutableLiveData

    fun setData(text : String){
        mutableLiveData.value = text
    }

}