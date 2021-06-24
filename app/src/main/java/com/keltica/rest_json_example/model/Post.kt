package com.keltica.rest_json_example.model

import com.google.gson.annotations.SerializedName

data class Post(
    val userID: Int,
    val id: Int,
    val title: String,
    val body: String
) {
}