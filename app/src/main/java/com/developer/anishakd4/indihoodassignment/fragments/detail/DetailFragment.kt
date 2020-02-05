package com.developer.anishakd4.indihoodassignment.fragments.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.developer.anishakd4.indihoodassignment.adapters.RepaymentScheduleAdapter
import com.developer.anishakd4.indihoodassignment.databinding.FragmentDetailBinding
import com.developer.anishakd4.indihoodassignment.model.TypeModel


class DetailFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = FragmentDetailBinding.inflate(inflater)
        binding.setLifecycleOwner(this)

        arguments?.let {
            val typeModel: TypeModel? = it.getParcelable("loanModel")
            typeModel?.let {
                Log.i("anisham", "anisham ${typeModel.repaymentSchedule}")
                binding.loanModel = typeModel
                val adapter= RepaymentScheduleAdapter()
                binding.repaymentSchedule.adapter = adapter
                adapter.submitList(typeModel.repaymentSchedule)

                binding.openGoogleMap.setOnClickListener {
                    openGoogleMap(typeModel.borrowerLocation.lat, typeModel.borrowerLocation.lng)
                }
            }
        }

        return binding.root
    }

    fun openGoogleMap(lat: Double, lng: Double){
        val geoUri = "http://maps.google.com/maps?q=loc:" + lat.toString() + "," + lng.toString() + " (" + "anish" + ")"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(geoUri))
        activity?.startActivity(intent)
    }
}