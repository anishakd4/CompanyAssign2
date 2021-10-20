package com.developer.anishakd4.indihoodassignment.fragments.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.developer.anishakd4.indihoodassignment.model.TypeModel
import com.developer.anishakd4.indihoodassignment.networking.LoanApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class OverviewFragmentViewModel : ViewModel() {

    private val _loans = MutableLiveData<List<TypeModel>>()
    val loans: LiveData<List<TypeModel>>
        get() = _loans

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getMarsRealEstateProperties()
    }

    private fun getMarsRealEstateProperties() {
        coroutineScope.launch {
            val getPropertiesDeferred = LoanApi.getLoanService.getLoans()
            try {
                val listResult = getPropertiesDeferred.await()
                if (listResult != null && listResult.size > 0) {
                    var typeModels: ArrayList<TypeModel>  = ArrayList<TypeModel>()
                    for ((key, value) in listResult) {
                        if(value != null && value.type.equals("loan_type")){
                            typeModels.add(value)
                        }
                    }
                    _loans.value = typeModels.toList()
                }
            } catch (t: Throwable) {
                Log.i("anisham", "anisham = fail ${t.localizedMessage}" )
            }

        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}