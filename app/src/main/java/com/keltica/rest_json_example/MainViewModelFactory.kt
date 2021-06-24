package com.keltica.rest_json_example

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.keltica.rest_json_example.respository.Repository

class MainViewModelFactory(private val repository: Repository) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}