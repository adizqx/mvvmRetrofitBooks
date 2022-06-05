package com.example.mvvmretrofitbooks.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.mvvmretrofitbooks.R
import com.example.mvvmretrofitbooks.databinding.FragmentDetailBinding
import com.example.mvvmretrofitbooks.model.Item


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val item = requireArguments().getSerializable(BOOK) as Item
        binding.tvAuthor.text = item.volumeInfo.authors[0]
        binding.tvName.text = item.volumeInfo.title
        binding.tvSubtitle.text = item.volumeInfo.subtitle
        binding.tvDesc.text = item.volumeInfo.description
        binding.tvData.text = item.volumeInfo.publishedDate
        binding.link.text = item.volumeInfo.previewLink
        Glide.with(requireContext()).load(item.volumeInfo.imageLinks.thumbnail).into(binding.ivBook)

        binding.link.setOnClickListener {
            val url = item.volumeInfo.previewLink
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            requireContext().startActivity(intent)
        }
    }


    companion object {
        private const val BOOK = "book"

        fun newInstance(item: Item): DetailFragment {
            val args = Bundle()
            args.putSerializable(BOOK, item)
            val fragment = DetailFragment()
            fragment.arguments = args
            return fragment
        }
    }


}