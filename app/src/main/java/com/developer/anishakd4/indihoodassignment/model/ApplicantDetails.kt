package com.developer.anishakd4.indihoodassignment.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ApplicantDetails(
    val Name: String,

    @field:SerializedName("Date of Birth")
    val dateOfBirth: String,

    @field:SerializedName("Phone Number")
    val phoneNumber: List<Long>,

    @field:SerializedName("Marital Status")
    val maritalStatus: String,

    @field:SerializedName("No of Dependents")
    val noOfDependents: Int
): Parcelable