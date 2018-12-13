package com.example.joe.codingchallengeissp.ui.main

import android.Manifest
import android.arch.lifecycle.ViewModelProviders
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.location.Location
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import com.example.joe.codingchallengeissp.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices


class MapsActivity : AppCompatActivity(){

    lateinit var viewModel: MainViewModel
     val LOCATION_REQUEST_CODE = 2
    private var latitude: Double = 0.0
    private var longitude: Double = 0.0
    lateinit var fusedLocation: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        getLocationPermissions()
        //viewModel.create()

        /*// Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)*/

    }

    fun getLocationPermissions() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
            != PackageManager.PERMISSION_GRANTED
        ) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            ) {
                AlertDialog.Builder(this)
                    .setTitle("Location Permission Needed")
                    .setMessage("This App Would Like To Use Your Location!")
                    .setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                        ActivityCompat.requestPermissions(
                            this,
                            arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION), LOCATION_REQUEST_CODE
                        )
                    })
                    .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() })
                    .create().show()
            } else {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_REQUEST_CODE
                )
            }
        } else {
            fusedLocation = LocationServices.getFusedLocationProviderClient(this)
            checkPermission("GPS?", 0 ,0)
            fusedLocation.lastLocation.addOnSuccessListener { location: Location? ->
                latitude = location!!.latitude
                longitude = location.longitude
/*
                viewModel.getResponse(latitude, longitude)
*/
                Log.d("MyLocation", "$latitude + $longitude")
            }
        }
    }

    fun justDoIt(view: View){
        viewModel.getResponse(latitude, longitude)
    }

}
