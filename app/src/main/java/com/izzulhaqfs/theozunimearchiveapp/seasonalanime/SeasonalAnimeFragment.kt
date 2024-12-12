package com.izzulhaqfs.theozunimearchiveapp.seasonalanime

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.izzulhaqfs.theozunimearchiveapp.R
import com.izzulhaqfs.theozunimearchiveapp.core.data.Resource
import com.izzulhaqfs.theozunimearchiveapp.core.ui.AnimeAdapter
import com.izzulhaqfs.theozunimearchiveapp.databinding.FragmentSeasonalAnimeBinding
import com.izzulhaqfs.theozunimearchiveapp.detail.DetailAnimeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.time.LocalDate
import java.util.Calendar

class SeasonalAnimeFragment : Fragment() {
    private var _binding: FragmentSeasonalAnimeBinding? = null
    private val binding get() = _binding!!
    private val seasonalAnimeViewModel: SeasonalAnimeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSeasonalAnimeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val calendar = Calendar.getInstance()
        val currentYear = calendar.get(Calendar.YEAR)
        val currentMonth = calendar.get(Calendar.MONTH)
        val currentSeason = when {
            currentMonth < 3 -> "winter"
            currentMonth in 3..5 -> "spring"
            currentMonth in 6..8 -> "summer"
            currentMonth in 9..11 -> "fall"
            else -> "season invalid"
        }

        if (activity != null) {
            val animeListAdapter = AnimeAdapter()
            animeListAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailAnimeActivity::class.java)
                intent.putExtra(DetailAnimeActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            seasonalAnimeViewModel.getSeasonalAnime(currentYear, currentSeason)
                .observe(viewLifecycleOwner) { animes ->
                    if (animes != null) {
                        when (animes) {
                            is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                            is Resource.Success -> {
                                binding.progressBar.visibility = View.GONE
                                animeListAdapter.submitList(animes.data)
                            }
                            is Resource.Error -> {
                                binding.progressBar.visibility = View.GONE
                                binding.viewError.root.visibility = View.VISIBLE
                                binding.viewError.tvError.text = animes.message ?: getString(R.string.view_error_message)
                            }
                        }
                    }
                }

            with(binding.rvAnimeSeasonal) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = animeListAdapter
            }
        }
    }
}