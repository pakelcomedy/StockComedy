package com.pakelcomedy.stockcomedy.ui.portfolio.crypto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.pakelcomedy.stockcomedy.data.model.CryptoPortfolio
import com.pakelcomedy.stockcomedy.databinding.FragmentCryptoPortfolioBinding

class CryptoPortfolioFragment : Fragment() {

    private var _binding: FragmentCryptoPortfolioBinding? = null
    private val binding get() = _binding!!
    private lateinit var cryptoPortfolioAdapter: CryptoPortfolioAdapter

    private val cryptoList = mutableListOf<CryptoPortfolio>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCryptoPortfolioBinding.inflate(inflater, container, false)

        // Initialize RecyclerView
        cryptoPortfolioAdapter = CryptoPortfolioAdapter(cryptoList)
        binding.cryptoPortfolioRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = cryptoPortfolioAdapter
        }

        // Load sample data
        loadSampleData()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Avoid memory leaks
    }

    private fun loadSampleData() {
        cryptoList.apply {
            clear() // Clear any existing data
            add(CryptoPortfolio("Bitcoin", "$42,000", "-$1,000 (-2%)"))
            add(CryptoPortfolio("Ethereum", "$3,000", "+$200 (+7%)"))
            add(CryptoPortfolio("Ripple", "$0.50", "-$0.10 (-10%)"))
        }
        cryptoPortfolioAdapter.notifyDataSetChanged()
    }
}