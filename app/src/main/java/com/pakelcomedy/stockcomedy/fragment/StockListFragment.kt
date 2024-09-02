package com.pakelcomedy.stockcomedy.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.pakelcomedy.stockcomedy.adapter.StockAdapter
import com.pakelcomedy.stockcomedy.databinding.FragmentStockListBinding
import com.pakelcomedy.stockcomedy.viewmodel.StockListViewModel

class StockListFragment : Fragment() {

    private var _binding: FragmentStockListBinding? = null
    private val binding get() = _binding!!

    private val stockListViewModel: StockListViewModel by viewModels()

    private lateinit var stockAdapter: StockAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStockListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup RecyclerView
        stockAdapter = StockAdapter()
        binding.rvStockList.layoutManager = LinearLayoutManager(context)
        binding.rvStockList.adapter = stockAdapter

        // Observasi perubahan data saham
        stockListViewModel.stockList.observe(viewLifecycleOwner) { stockList ->
            stockAdapter.submitList(stockList)
        }

        // Setup tombol beli dan jual
        binding.btnBuyStock.setOnClickListener {
            // Handle buy action
            // Example: You might show a dialog to select the stock to buy
        }

        binding.btnSellStock.setOnClickListener {
            // Handle sell action
            // Example: You might show a dialog to select the stock to sell
        }

        // Fetch saham dari ViewModel
        stockListViewModel.fetchStocks()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
