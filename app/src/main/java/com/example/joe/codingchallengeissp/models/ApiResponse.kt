package com.example.joe.codingchallengeissp.models

import com.google.gson.annotations.SerializedName

data class ApiResponse(@SerializedName("message") val message:String,
                       @SerializedName("request") val request: Request,
                       @SerializedName("response") val response: List<Response>)