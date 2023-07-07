package com.example.lovelocalassigment.ui.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lovelocalassigment.R
import com.example.lovelocalassigment.databinding.FragmentHomeBinding
import com.example.lovelocalassigment.ui.home.adapter.CategoryListAdapter
import com.example.lovelocalassigment.ui.home.model.CategoryListModel
import com.example.lovelocalassigment.ui.home.viewmodel.CategoryListViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(CategoryListViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val recyclerview = binding.recyclerview
        val gridLayoutManager = GridLayoutManager(activity, 2)
        gridLayoutManager.orientation = LinearLayoutManager.VERTICAL // set Horizontal Orientation
        recyclerview.setLayoutManager(gridLayoutManager)


        homeViewModel.categoryList.observe(viewLifecycleOwner, Observer {itx ->
            // This will pass the list to our Adapter
            val adapter = activity?.let { CategoryListAdapter(itx, it) }
            // Setting the Adapter with the recyclerview
            recyclerview.adapter = adapter
        })



        homeViewModel.getCategoryList()




        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


