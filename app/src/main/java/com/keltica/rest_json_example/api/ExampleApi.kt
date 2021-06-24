package com.keltica.rest_json_example.api

import com.keltica.rest_json_example.model.Post
import retrofit2.http.GET

interface ExampleApi {

  @GET("posts/1")
  suspend fun getPost(): Post
}