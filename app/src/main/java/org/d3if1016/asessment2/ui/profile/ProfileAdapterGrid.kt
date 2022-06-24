package org.d3if1016.asessment2.ui.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import org.d3if1016.asessment2.network.Profile
import androidx.recyclerview.widget.RecyclerView
import org.d3if1016.asessment2.databinding.ProfileLayoutBinding

class ProfileAdapterGrid : ListAdapter<Profile, ProfileAdapterGrid.ProfileViewHolder>(DiffCallback) {

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ProfileViewHolder {
            return ProfileViewHolder(ProfileLayoutBinding.inflate(LayoutInflater.from(parent.context)))
        }

        override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
            val marsPhoto = getItem(position)
            holder.bind(marsPhoto)
        }

        class ProfileViewHolder(private var binding: ProfileLayoutBinding): RecyclerView.ViewHolder(binding.root){
            fun bind(Profile: Profile){
                binding.profile = Profile
                binding.executePendingBindings()
            }
        }

        companion object DiffCallback: DiffUtil.ItemCallback<Profile>() {
            override fun areItemsTheSame(oldItem: Profile, newItem: Profile): Boolean {
                return oldItem.nama == newItem.nama
            }

            override fun areContentsTheSame(oldItem: Profile, newItem: Profile): Boolean {
                return oldItem.imageUrl == newItem.imageUrl
            }
        }
    }