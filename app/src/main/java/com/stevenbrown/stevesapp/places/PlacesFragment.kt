package com.stevenbrown.stevesapp.places

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stevenbrown.stevesapp.databinding.FragmentPlacesBinding
import com.stevenbrown.stevesapp.models.Place

class PlacesFragment : Fragment() {

    lateinit var binding: FragmentPlacesBinding
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlacesBinding.inflate(inflater, container, false)
        recyclerView = binding.placesRecyclerview
        initRecyclerView()
        return binding.root
    }

    private fun initRecyclerView() {
        val adapter = PlacesAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter.setData(arrayListOf(Place("Steve's House"), Place("Nate's House"), Place("FedEx"), Place("Universe")))
    }

    companion object {
        fun newInstance(): PlacesFragment {
            val args = Bundle()
            val fragment = PlacesFragment()
            fragment.arguments = args
            return fragment
        }
    }
}