package com.example.joe.codingchallengeissp.models

import com.google.gson.annotations.SerializedName

data class Request(@SerializedName ("altitude") val altitude: Int,
                   @SerializedName("datetime") val datetime:Int,
                   @SerializedName("latitude") val latitude:Double,
                   @SerializedName("longitude") val longitude:Double,
                   @SerializedName("passes") val passes: Int)