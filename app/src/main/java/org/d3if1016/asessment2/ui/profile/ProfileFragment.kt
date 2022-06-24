package org.d3if1016.asessment2.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import org.d3if1016.asessment2.databinding.FragmentExitBinding
import org.d3if1016.asessment2.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentExitBinding? = null
    private val binding get() = _binding!!

    private val viewModel : ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val ProfileViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentExitBinding.inflate(inflater, container, false)

        val binding = FragmentProfileBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModelprofile = viewModel

        binding.imageProfile.adapter = ProfileAdapterGrid()

        return binding.root
    }
}