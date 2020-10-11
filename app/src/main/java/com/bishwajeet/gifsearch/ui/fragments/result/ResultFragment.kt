package com.bishwajeet.gifsearch.ui.fragments.result

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.bishwajeet.gifsearch.R
import com.bishwajeet.gifsearch.ui.activities.detail.DetailViewModel
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultFragment : Fragment() {

    private val searchResultViewModel: DetailViewModel by activityViewModels()
    private val args by navArgs<ResultFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_search_result_detail, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvHeading = view.findViewById<TextView>(R.id.tvHeading)
        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val tvContent = view.findViewById<TextView>(R.id.tvContent)
        val tvRating = view.findViewById<TextView>(R.id.tvRating)
        val imgGif = view.findViewById<ImageView>(R.id.imgGif)
        val btnCopy = view.findViewById<TextView>(R.id.btnCopy)

        searchResultViewModel.receiveUserAction(
            GifDetailAction.ScreenOpenWithId(args.id)
        )

        searchResultViewModel.gifDetailResult.observe(viewLifecycleOwner,
            Observer { result ->
                result ?: return@Observer
                result.error?.let {
                    showError(it)
                }
                result.success?.let { uiModel ->
                    tvHeading.text = uiModel.title
                    tvTitle.text = uiModel.title
                    tvContent.text = uiModel.gif_url
                    tvRating.text = uiModel.rating
                    Glide.with(this).load(uiModel.gif_url).into(imgGif)

                    btnCopy.setOnClickListener {
                        val clipboard =
                            requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                        val clip: ClipData = ClipData.newPlainText(uiModel.title, uiModel.gif_url)
                        clipboard.setPrimaryClip(clip)
                        Toast.makeText(
                            requireContext(),
                            resources.getString(R.string.link_copied),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            })
    }


    private fun showError(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_LONG).show()
    }
}