package org.d3if1016.asessment2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.d3if1016.asessment2.R
import org.d3if1016.asessment2.RecyclerViewClickListener
import org.d3if1016.asessment2.ReviewViewModel
import org.d3if1016.asessment2.databinding.CustomReviewBinding

class AdapterReview(private val mList: List<ReviewViewModel>) :
    RecyclerView.Adapter<AdapterReview.CustomReviewViewHolder>() {

    var listener: RecyclerViewClickListener? = null

    inner class CustomReviewViewHolder(
        val customReviewBinding: CustomReviewBinding
        ) : RecyclerView.ViewHolder(customReviewBinding.root)

    override fun getItemCount() = mList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CustomReviewViewHolder (
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.custom_review, parent, false)
    )

    override fun onBindViewHolder(holder: CustomReviewViewHolder, position: Int) {
        holder.customReviewBinding.textViewNama.text = mList[position].nama
        holder.customReviewBinding.textViewReview.text = mList[position].review

        holder.customReviewBinding.cardView.setOnClickListener {
            listener?.onItemClicked(it, mList[position])
        }
    }

}