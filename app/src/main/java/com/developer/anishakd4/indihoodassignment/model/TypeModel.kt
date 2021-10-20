package com.developer.anishakd4.indihoodassignment.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TypeModel(
    val type: String,
    val title: String,
    val image: ImageModel,
    @field:SerializedName("Borrower Location")
    val borrowerLocation: AddressModel,
    @field:SerializedName("Applicant Details")
    val applicantDetails: ApplicantDetails,
    @field:SerializedName("Loan Terms")
    val loanTerms: LoanTerms,
    @field:SerializedName("Repayment Schedule")
    val repaymentSchedule: List<RepaymentSchedule>
): Parcelable