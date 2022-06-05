package com.example.mvvmretrofitbooks.ui

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmretrofitbooks.databinding.ItemBookBinding
import com.example.mvvmretrofitbooks.model.Item


class BooksAdapter : RecyclerView.Adapter<BooksAdapter.bookViewHolder>() {
    var searchList = emptyList<Item>()

    var onItemClickListener: ((Item) -> Unit)? = null

    inner class bookViewHolder(binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root) {
        val title = binding.tvTitle
        val image = binding.image
        val subtitle = binding.tvSubtitle
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bookViewHolder {
        return bookViewHolder(
            ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: bookViewHolder, position: Int) {
        val item = searchList[position]
        holder.title.text = item.volumeInfo.title
        holder.subtitle.text = item.volumeInfo.subtitle
        Glide.with(holder.itemView.context).load(item.volumeInfo.imageLinks.smallThumbnail).into(holder.image)

        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(item)
        }

    }

    override fun getItemCount(): Int {
        return searchList.size
    }

    fun setList(list: List<Item>) {
        searchList = list
        notifyDataSetChanged()
    }

}