package org.d3if1016.asessment2.ui.exit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.d3if1016.asessment2.databinding.FragmentExitBinding

class ExitFragment : Fragment() {

    private var _binding: FragmentExitBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(ExiitViewModel::class.java)

        _binding = FragmentExitBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.buttonExit.setOnClickListener {
            activity?.finish()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}