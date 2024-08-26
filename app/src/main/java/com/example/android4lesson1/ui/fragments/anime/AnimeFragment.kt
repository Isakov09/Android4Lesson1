package com.example.android4lesson1.ui.fragments.anime

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.example.android4lesson1.R
import com.example.android4lesson1.databinding.FragmentAnimeBinding
import com.example.android4lesson1.ui.adapter.AnimeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeFragment : Fragment(R.layout.fragment_anime) {

    private var _binding: FragmentAnimeBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<AnimeViewModel>()
    private val animeAdapter = AnimeAdapter(:: onClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnimeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObserver()
        fetchData()
    }

    private fun setupObserver() {
        viewModel.animeLiveData.observe(viewLifecycleOwner) { response ->
            // Убедитесь, что данные не null
            response?.let {
                // Обновите адаптер с новыми данными
                animeAdapter.submitList(it.data) // Предполагаем, что `data` это список аниме
            }
        }
    }

    private fun initialize() {
        binding.rvAnime.adapter = animeAdapter
    }

    private fun fetchData() {
        // Вызов метода fetchAnime из ViewModel
        viewModel.fetchAnime() // Пример вызова без параметров, можно передать limit и offset
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onClick(id: String) {
        findNavController().navigate(
            AnimeFragmentDirections.actionAnimeFragmentToDetailFragment()
        )
    }
}