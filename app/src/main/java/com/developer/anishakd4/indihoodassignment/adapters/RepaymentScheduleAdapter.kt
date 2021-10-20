package com.developer.anishakd4.indihoodassignment.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.developer.anishakd4.indihoodassignment.databinding.LoanItemBinding
import com.developer.anishakd4.indihoodassignment.databinding.LoanRepaymentItemBinding
import com.developer.anishakd4.indihoodassignment.model.RepaymentSchedule
import com.developer.anishakd4.indihoodassignment.model.TypeModel

class RepaymentScheduleAdapter() : ListAdapter<RepaymentSchedule, RepaymentScheduleAdapter.ViewHolder>(DiffCallBack) {

    companion object DiffCallBack : DiffUtil.ItemCallback<RepaymentSchedule>() {
        override fun areItemsTheSame(oldItem: RepaymentSchedule, newItem: RepaymentSchedule): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: RepaymentSchedule, newItem: RepaymentSchedule): Boolean {
            return oldItem == newItem
        }
    }

    class ViewHolder(private var binding: LoanRepaymentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(repaymentSchedule: RepaymentSchedule) {
            binding.repaymentSchedule = repaymentSchedule
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i("anisham", "anisham onCreateViewHolder")
        return ViewHolder(LoanRepaymentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i("anisham", "anisham $itemCount")
        val item = getItem(position)
        holder.bind(item)
    }
}
