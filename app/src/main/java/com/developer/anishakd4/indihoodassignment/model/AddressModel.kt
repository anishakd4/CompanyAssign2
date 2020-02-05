package com.developer.anishakd4.indihoodassignment.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AddressModel(val lat: Double, val lng: Double, val address: String): Parcelable