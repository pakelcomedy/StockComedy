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
    ): View {
        _binding = FragmentStockListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup RecyclerView
        stockAdapter = StockAdapter(emptyList()) // Initialize with an empty list
        binding.rvStockList.layoutManager = LinearLayoutManager(context)
        binding.rvStockList.adapter = stockAdapter

        // Observe changes in stock list
        stockListViewModel.allStocks.observe(viewLifecycleOwner) { stockList ->
            stockAdapter.updateStockList(stockList) // Update the adapter with new data
        }

        // Setup buy and sell buttons
        binding.btnBuyStock.setOnClickListener {
            // Handle buy action
        }

        binding.btnSellStock.setOnClickListener {
            // Handle sell action
        }

        // Fetch stocks from ViewModel
        stockListViewModel.fetchStocks() // Ensure this method is defined in StockListViewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
