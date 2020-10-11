package com.bishwajeet.gifsearch.ui.fragments.search

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.bishwajeet.gifsearch.model.GifSearchUIModel

class GifListAdapter(private val listener: GifSelectionListener): PagingDataAdapter<GifSearchUIModel, GifViewHolder>(GIF_COMPARATOR) {

    override fun onBindViewHolder(holder: GifViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder {
        return GifViewHolder.create(parent, listener)
    }

    companion object {
        private val GIF_COMPARATOR = object : DiffUtil.ItemCallback<GifSearchUIModel>() {
            override fun areItemsTheSame(oldItem: GifSearchUIModel, newItem: GifSearchUIModel): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: GifSearchUIModel, newItem: GifSearchUIModel): Boolean =
                oldItem == newItem
        }
    }
}