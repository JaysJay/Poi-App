package com.sans.poi.utility

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class MapsHelper(
    val context: Context
) {
    fun getFusedLocationProviderClient():FusedLocationProviderClient?{
        return try {
            LocationServices.getFusedLocationProviderClient(context)
        }catch (e:Exception){
            e.printStackTrace()
            null
        }
    }

    fun getDefaultLocation(callback: (Location?) -> Unit){
        try {
            if (isPermissionLocationApproved(context)) {
                with(getFusedLocationProviderClient()){
                    this?.let {
                        lastLocation.addOnSuccessListener { location: Location? ->
                            if (location != null) {
                                callback.invoke(location)
                            }
                        }
                    }
                }
            }
            return callback.invoke(null)
        }catch (e:Exception){
            e.printStackTrace()
            return callback.invoke(null)
        }
    }

    fun isPermissionLocationApproved(context: Context):Boolean{
        if(ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED){
            return true
        }
        return false

    }


    fun requestLocationPermission(activity: Activity) {
        ActivityCompat.requestPermissions(
            activity,
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
            ),
            99
        )
    }
}