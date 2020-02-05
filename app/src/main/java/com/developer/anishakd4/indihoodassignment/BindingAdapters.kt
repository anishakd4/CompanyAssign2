package com.developer.anishakd4.indihoodassignment

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.developer.anishakd4.indihoodassignment.adapters.RecyclerviewAdapter
import com.developer.anishakd4.indihoodassignment.model.TypeModel

@BindingAdapter("listdata")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<TypeModel>?){
    val adapter = recyclerView.adapter as RecyclerviewAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?){
    imgUrl?.let {
        val imgUri = it.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(RequestOptions().placeholder(R.drawable.loading_animation).error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}

@BindingAdapter("arrayListData")
fun bindArrayToTextview(textView: TextView, phoneNumber: List<Long>?){

    var text = ""
    if (phoneNumber != null) {
        for(ll in phoneNumber){

        }
        phoneNumber.forEachIndexed { index, l ->
            text = text + l.toString()
            if(index != phoneNumber.size - 1){
                text = text + " ,"
            }
        }
    }
    textView.text = text
}