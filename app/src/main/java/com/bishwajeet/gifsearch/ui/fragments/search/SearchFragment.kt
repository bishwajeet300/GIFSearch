package com.bishwajeet.gifsearch.ui.fragments.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bishwajeet.gifsearch.R
import com.bishwajeet.gifsearch.model.GifSearchUIModel
import com.bishwajeet.gifsearch.ui.activities.main.MainViewModel
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : Fragment(), GifSelectionListener {

    private val searchListViewModel: MainViewModel by activityViewModels()
    private val gifListAdapter = GifListAdapter(this)

    private var columnCount = 3
    private var queryValidation = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_search_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvGigList = view.findViewById<RecyclerView>(R.id.list)
        val resultLayout = view.findViewById<ConstraintLayout>(R.id.resultLayout)
        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val tvContent = view.findViewById<TextView>(R.id.tvContent)
        val tvRating = view.findViewById<TextView>(R.id.tvRating)
        val imgGif = view.findViewById<ImageView>(R.id.imgGif)

        searchListViewModel.receiveUserAction(
            GifSearchAction.ScreenOpen
        )

        with(rvGigList) {
            layoutManager = when {
                columnCount <= 1 -> LinearLayoutManager(context)
                else -> GridLayoutManager(context, columnCount)
            }
            adapter = gifListAdapter
        }

        searchListViewModel.gifDetailResult.observe(viewLifecycleOwner,
            Observer { result ->
                result ?: return@Observer
                result.error?.let {
                    showError(it)
                }
                result.success?.let {
                    tvTitle.text = it.title
                    tvContent.text = it.gif_url
                    tvRating.text = it.rating
                    Glide.with(this).load(it.gif_url).into(imgGif)
                }
            })

        searchListViewModel.isValidQuery.observe(viewLifecycleOwner,
            Observer { result ->
                result ?: return@Observer
                queryValidation = result

                if (queryValidation) {
                    resultLayout.visibility = View.GONE
                    rvGigList.visibility = View.VISIBLE

                    lifecycleScope.launch {
                        searchListViewModel.searchGif().collectLatest { pagingData ->
                            gifListAdapter.submitData(pagingData)
                        }
                    }
                } else {
                    rvGigList.visibility = View.GONE
                    resultLayout.visibility = View.VISIBLE

                }
            })
    }


    override fun onClick(gifSearchUIModel: GifSearchUIModel) {
        val directions = SearchFragmentDirections.navigateToGifDetail(gifSearchUIModel.id)
        findNavController().navigate(directions)
    }


    private fun showError(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_LONG).show()
    }
}