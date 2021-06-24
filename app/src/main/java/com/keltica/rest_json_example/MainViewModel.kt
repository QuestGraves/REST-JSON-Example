package com.keltica.rest_json_example

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keltica.rest_json_example.model.Post
import com.keltica.rest_json_example.respository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {

    val mResponse: MutableLiveData<Post> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
            val response: Post = repository.getPost()
            mResponse.value = response
        }
    }
}