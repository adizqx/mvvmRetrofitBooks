package com.example.mvvmretrofitbooks.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmretrofitbooks.R
import com.example.mvvmretrofitbooks.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val booksAdapter by lazy { BooksAdapter() }
    private lateinit var searchViewModel: HomeViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        searchViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rcViewSearch.adapter = booksAdapter
        binding.rcViewSearch.layoutManager = LinearLayoutManager(requireContext())

        searchViewModel.searchListt.observe(viewLifecycleOwner, {
            booksAdapter.setList(it)
        })

        binding.ibSearch.setOnClickListener {
            searchViewModel.getSearchNews(binding.etSearch.text.toString())
        }

        setupClickListener()
    }

    private fun setupClickListener() {
        booksAdapter.onItemClickListener = {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, DetailFragment.newInstance(it))
                .addToBackStack(null)
                .commit()
        }
    }


}