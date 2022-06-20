package org.d3if1016.asessment2.ui.home

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.work.WorkManager
import org.d3if1016.asessment2.adapter.AdapterReview
import org.d3if1016.asessment2.dao.ReviewDao
import org.d3if1016.asessment2.RecyclerViewClickListener
import org.d3if1016.asessment2.ReviewViewModel
import org.d3if1016.asessment2.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), RecyclerViewClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val data = ArrayList<ReviewViewModel>()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        loadData()

        return root
    }

        fun loadData(){
        data.clear()
        val db = context?.let { ReviewDao(it, null) }
        val cursor = db?.getReview()
        cursor!!.moveToFirst()
        while(cursor.moveToNext()){
            data.add(ReviewViewModel(
                cursor.getString(cursor.getColumnIndexOrThrow(ReviewDao.NAME_COl)),
                cursor.getString(cursor.getColumnIndexOrThrow(ReviewDao.REVIEW_COL))
            ))
        }
        cursor.close()
        val adapter = AdapterReview(data)
        binding.recyclerView.adapter = adapter
        adapter.listener = this
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClicked(view: View, reviewViewModel: ReviewViewModel) {
        val builder = AlertDialog.Builder(
            requireContext()
        )
        val dialogClickListener =
            DialogInterface.OnClickListener { dialog, which ->
                when (which) {
                    DialogInterface.BUTTON_POSITIVE -> {
                        val db = context?.let { ReviewDao(it, null) }
                        db?.delete(reviewViewModel.nama)
                        Toast.makeText(context, "Data berhasil dihapus", Toast.LENGTH_SHORT).show()
                        loadData()
                    }
                    DialogInterface.BUTTON_NEGATIVE -> {}
                }
            }

        builder.setMessage("Apakah Anda ingin menghapus data ini?").setPositiveButton("Yes", dialogClickListener)
            .setNegativeButton("No", dialogClickListener).show()
    }
}