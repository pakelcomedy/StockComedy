package com.pakelcomedy.stockcomedy.ui.portfolio.stock

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pakelcomedy.stockcomedy.R
import com.pakelcomedy.stockcomedy.data.model.StockPortfolio
import androidx.navigation.fragment.findNavController

class StockPortfolioFragment : Fragment() {

    private lateinit var portfolioRecyclerView: RecyclerView
    private lateinit var portfolioAdapter: StockPortfolioAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_stock_portfolio, container, false)

        // Initialize RecyclerView
        portfolioRecyclerView = view.findViewById(R.id.portfolioRecyclerView)

        // Sample portfolio data
        val portfolioList = listOf(
            StockPortfolio("AAPL", "$42,000", "-$1,000 (-2%)"),
            StockPortfolio("GOOGL", "$3,000", "+$200 (+7%)"),
            StockPortfolio("MSFT", "$0.50", "-$0.10 (-10%)"),
            StockPortfolio("AMZN", "$150", "+$15 (+11%)"),
            StockPortfolio("TSLA", "$0.07", "-$0.02 (-22%)")
        )

        // Initialize Adapter and LayoutManager
        portfolioAdapter = StockPortfolioAdapter(portfolioList) { stock ->
            // On item click, navigate to the ChartFragment
            val action = StockPortfolioFragmentDirections
                .actionStockPortfolioFragmentToChartFragment(stock.name) // Pass stock name or symbol
            findNavController().navigate(action)
        }
        portfolioRecyclerView.adapter = portfolioAdapter
        portfolioRecyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }
}