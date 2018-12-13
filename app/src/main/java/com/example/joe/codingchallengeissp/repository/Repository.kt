package com.example.joe.codingchallengeissp.repository

import com.example.joe.codingchallengeissp.models.ApiResponse
import io.reactivex.Single

interface Repository {
    fun getResponse(latitude: Double, longitude: Double): Single<ApiResponse>
}