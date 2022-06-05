package com.example.mvvmretrofitbooks.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmretrofitbooks.model.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel:ViewModel() {
    private val searchRepository = MainRepository()
    var searchListt = MutableLiveData<List<Item>>()


    fun getSearchNews(query: String){
        viewModelScope.launch(Dispatchers.IO) {
            val list = searchRepository.getBookByName(query)
            withContext(Dispatchers.Main){
                searchListt.value = list!!
            }
        }
    }
}