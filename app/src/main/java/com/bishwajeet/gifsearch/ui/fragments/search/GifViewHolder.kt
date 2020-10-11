package com.bishwajeet.gifsearch.ui.fragments.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bishwajeet.gifsearch.R
import com.bishwajeet.gifsearch.model.GifSearchUIModel
import com.bumptech.glide.Glide

class GifViewHolder(private val view: View, private val listener: GifSelectionListener) : RecyclerView.ViewHolder(view) {

    private val imgGif: ImageView = view.findViewById(R.id.imgGif)


    fun bind(gifSearchUIModel: GifSearchUIModel) {
        view.setOnClickListener {
            listener.onClick(gifSearchUIModel)
        }

        Glide
            .with(view)
            .load(gifSearchUIModel.image_url)
            .centerCrop()
            .placeholder(R.drawable.ic_image)
            .into(imgGif)
    }

    companion object {
        fun create(parent: ViewGroup, listener: GifSelectionListener): GifViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
            return GifViewHolder(view, listener)
        }
    }
}