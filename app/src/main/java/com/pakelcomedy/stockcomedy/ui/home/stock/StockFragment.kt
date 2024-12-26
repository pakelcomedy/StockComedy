package com.pakelcomedy.stockcomedy.ui.home.stock

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pakelcomedy.stockcomedy.R
import com.pakelcomedy.stockcomedy.data.model.Stock

class StockFragment : Fragment() {

    private lateinit var stockRecyclerView: RecyclerView
    private lateinit var stockAdapter: StockAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_stock, container, false)
        stockRecyclerView = view.findViewById(R.id.stockRecyclerView)

        val stockList = listOf(
            Stock("AAPL", "$21000", "+21%"),
            Stock("GOOGL", "$15000", "-5%"),
            Stock("MSFT", "$18000", "+3%"),
            Stock("AMZN", "$25000", "+12%")
        )

        stockAdapter = StockAdapter(stockList)
        stockRecyclerView.adapter = stockAdapter
        stockRecyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }
}