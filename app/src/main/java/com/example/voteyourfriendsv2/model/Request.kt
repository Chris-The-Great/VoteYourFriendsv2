package com.example.voteyourfriendsv2.model

import com.google.gson.annotations.SerializedName

data class Request(
    @SerializedName("questions")
    var question : String? = null
)