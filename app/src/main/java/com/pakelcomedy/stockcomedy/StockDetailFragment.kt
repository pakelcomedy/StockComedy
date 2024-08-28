package com.pakelcomedy.stockcomedy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class StockDetailFragment : Fragment() {

    private lateinit var tvStockName: TextView
    private lateinit var tvStockPrice: TextView
    private lateinit var tvStockChange: TextView
    private lateinit var btnBuy: Button
    private lateinit var btnSell: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_stock_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize views
        tvStockName = view.findViewById(R.id.tvStockName)
        tvStockPrice = view.findViewById(R.id.tvStockPrice)
        tvStockChange = view.findViewById(R.id.tvStockChange)
        btnBuy = view.findViewById(R.id.btnBuy)
        btnSell = view.findViewById(R.id.btnSell)

        // Set up initial data or update UI
        // Example: setting dummy data
        val stockName = "Example Stock"
        val stockPrice = "$123.45"
        val stockChange = "+1.23%"

        tvStockName.text = stockName
        tvStockPrice.text = stockPrice
        tvStockChange.text = "Change: $stockChange"

        // Handle button clicks
        btnBuy.setOnClickListener {
            // Handle buy action
        }

        btnSell.setOnClickListener {
            // Handle sell action
        }
    }
}
