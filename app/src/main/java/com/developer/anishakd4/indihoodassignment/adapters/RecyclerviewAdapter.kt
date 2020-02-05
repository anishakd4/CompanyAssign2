package com.developer.anishakd4.indihoodassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.developer.anishakd4.indihoodassignment.model.TypeModel
import com.developer.anishakd4.indihoodassignment.databinding.LoanItemBinding

class RecyclerviewAdapter(val loanClickListener: LoanClickListener) : ListAdapter<TypeModel, RecyclerviewAdapter.LoanViewHolder>(DiffCallBack) {

    companion object DiffCallBack : DiffUtil.ItemCallback<TypeModel>() {
        override fun areItemsTheSame(oldItem: TypeModel, newItem: TypeModel): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: TypeModel, newItem: TypeModel): Boolean {
            return oldItem.title == newItem.title
        }
    }

    class LoanViewHolder(private var binding: LoanItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(loan: TypeModel, loanClickListener: LoanClickListener) {
            binding.loanModel = loan
            binding.clickListener = loanClickListener
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoanViewHolder {
        return LoanViewHolder(LoanItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: LoanViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, loanClickListener)
    }
}

class LoanClickListener(val clickListener: (typeModel: TypeModel) -> Unit) {
    fun onClick(typeModel: TypeModel) {
        clickListener(typeModel)
    }
}