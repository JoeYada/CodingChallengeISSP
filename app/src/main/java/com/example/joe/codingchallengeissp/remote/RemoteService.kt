package com.example.joe.codingchallengeissp.remote

import com.example.joe.codingchallengeissp.common.RELATIVE_URL
import com.example.joe.codingchallengeissp.models.ApiResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteService {
    @GET(RELATIVE_URL)
    fun getResponse(@Query("lat") latitude: String,
                    @Query("lon") longitude: String):Single<ApiResponse>
}