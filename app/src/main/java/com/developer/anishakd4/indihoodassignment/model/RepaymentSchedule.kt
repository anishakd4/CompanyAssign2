package com.developer.anishakd4.indihoodassignment.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RepaymentSchedule(
    val Date: String,
    val Amount: Int
): Parcelable