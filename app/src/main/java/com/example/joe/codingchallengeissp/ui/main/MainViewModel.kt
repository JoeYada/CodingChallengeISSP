package com.example.joe.codingchallengeissp.ui.main

import android.arch.lifecycle.ViewModel
import android.os.NetworkOnMainThreadException
import android.util.Log
import com.example.joe.codingchallengeissp.models.ApiResponse
import com.example.joe.codingchallengeissp.repository.RepositoryImpl
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class MainViewModel() : ViewModel() {
    var repo: RepositoryImpl = RepositoryImpl()

    fun getResponse(latitude: Double, longitude: Double) {
        repo.getResponse(latitude, longitude)
            .subscribe(object : SingleObserver<ApiResponse> {
                override fun onSuccess(t: ApiResponse) {
                    Log.d(
                        "myLocalResponse", "${t.request.altitude} + ${t.request.datetime}" +
                                " + ${t.request.latitude} + ${t.request.longitude} + ${t.request.passes}"
                    )
                }

                override fun onSubscribe(d: Disposable) {
                    d?.dispose()
                }

                override fun onError(e: Throwable) {
                    Log.d("myLocalResponse", "Errors for Days")
                    e.printStackTrace()

                }

            })
    }
}