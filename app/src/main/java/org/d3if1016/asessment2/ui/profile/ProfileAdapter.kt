package org.d3if1016.asessment2.ui.profile

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.d3if1016.asessment2.R
import org.d3if1016.asessment2.network.Profile


@BindingAdapter("imageId")
fun bindImage(imgView: ImageView, imageId: String?){
    imageId?.let{
        val imageId = imageId.toUri().buildUpon().scheme("https").build()
        imgView.load(imageId){
            placeholder(R.drawable.loading_indicator)
            error(R.drawable.ic_icon_error)
        }
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Profile>?){
    val adapter = recyclerView.adapter as ProfileAdapterGrid
    adapter.submitList(data)
}

@BindingAdapter("ReviewService")
fun bindStatus(statusImageView: ImageView, status: ProfileApiStatus?){
    when(status){
        ProfileApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_indicator)
        }
        ProfileApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_icon_error)
        }
        ProfileApiStatus.SUCCESS -> {
            statusImageView.visibility = View.GONE
        }
    }
}