package com.developer.anishakd4.indihoodassignment.fragments.overview

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.developer.anishakd4.indihoodassignment.R
import com.developer.anishakd4.indihoodassignment.adapters.LoanClickListener
import com.developer.anishakd4.indihoodassignment.adapters.RecyclerviewAdapter
import com.developer.anishakd4.indihoodassignment.databinding.FragmentOverviewBinding
import com.developer.anishakd4.indihoodassignment.fragments.detail.DetailFragment

class OverviewFragment : Fragment() {

    private val viewModel: OverviewFragmentViewModel by lazy {
        ViewModelProvider(this).get(OverviewFragmentViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentOverviewBinding.inflate(inflater)
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel

        binding.loansList.adapter = RecyclerviewAdapter(LoanClickListener{
            val fragment = DetailFragment()
            val args = Bundle()
            args.putParcelable("loanModel", it)
            fragment.setArguments(args)
            parentFragmentManager.beginTransaction().replace(R.id.fragment, fragment).addToBackStack("detail").commit()
        })
        return binding.root
    }

}