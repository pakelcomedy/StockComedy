package com.pakelcomedy.stockcomedy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment

class StockMarketFragment : Fragment() {

    private lateinit var tvSelectedStock: TextView
    private lateinit var tvStockChange: TextView
    private lateinit var lvStockList: ListView
    private lateinit var btnBuyStock: Button
    private lateinit var btnSellStock: Button

    private val stockList = listOf("Stock A", "Stock B", "Stock C")
    private var selectedStock: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_stock_market, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize views
        tvSelectedStock = view.findViewById(R.id.tvSelectedStock)
        tvStockChange = view.findViewById(R.id.tvStockChange)
        lvStockList = view.findViewById(R.id.lvStockList)
        btnBuyStock = view.findViewById(R.id.btnBuyStock)
        btnSellStock = view.findViewById(R.id.btnSellStock)

        // Set up ListView
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, stockList)
        lvStockList.adapter = adapter

        lvStockList.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            selectedStock = stockList[position]
            tvSelectedStock.text = "Selected Stock: $selectedStock"
            tvStockChange.text = "Change: +1.23%" // Example change
        }

        // Handle button clicks
        btnBuyStock.setOnClickListener {
            selectedStock?.let {
                // Handle buy action
            }
        }

        btnSellStock.setOnClickListener {
            selectedStock?.let {
                // Handle sell action
            }
        }
    }
}
