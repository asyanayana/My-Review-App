package org.d3if1016.asessment2.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.d3if1016.asessment2.dao.ReviewDao
import org.d3if1016.asessment2.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: AddViewModel by lazy {
        ViewModelProvider(this).get(AddViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(AddViewModel::class.java)

        _binding = FragmentAddBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.buttonSubmit.setOnClickListener {
            val name = binding.textInputEditTextNama.text.toString()
            val age = binding.textInputEditTextReview.text.toString()
            context?.let { it1 -> ReviewDao(it1, null) }?.addReview(name, age)
            Toast.makeText(context, "Review added to database", Toast.LENGTH_LONG).show()
            binding.textInputEditTextNama.text?.clear()
            binding.textInputEditTextReview.text?.clear()

            viewModel.scheduleUpdater(requireActivity().application)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}