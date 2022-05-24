package org.d3if1016.asessment2

import android.view.View

interface RecyclerViewClickListener {
    fun onItemClicked(view: View, reviewViewModel: ReviewViewModel)
}