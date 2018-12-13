package com.example.joe.codingchallengeissp.repository

import com.example.joe.codingchallengeissp.models.ApiResponse
import com.example.joe.codingchallengeissp.remote.RemoteHelper
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RepositoryImpl: Repository {
    override fun getResponse(latitude: Double, longitude: Double): Single<ApiResponse> {
        return RemoteHelper.getResponse(latitude, longitude).observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}