package com.developer.anishakd4.indihoodassignment.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LoanTerms(
    val Duration: String,

    @field:SerializedName("Interest Rate")
    val InterestRate: String,

    @field:SerializedName("Loan Amount")
    val LoanAmount: Int,

    @field:SerializedName("Loan Product")
    val LoanProduct: String
): Parcelable