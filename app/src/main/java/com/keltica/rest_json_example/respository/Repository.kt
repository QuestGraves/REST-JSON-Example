package com.keltica.rest_json_example.respository

import com.keltica.rest_json_example.api.RetrofitInstance
import com.keltica.rest_json_example.model.Post

class Repository {

    suspend fun getPost(): Post {
        return RetrofitInstance.api.getPost()
    }
}