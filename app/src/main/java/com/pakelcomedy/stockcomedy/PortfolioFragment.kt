package com.pakelcomedy.stockcomedy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PortfolioFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var portfolioAdapter: PortfolioAdapter
    private val portfolioItems = listOf(
        PortfolioItem("Stock Name 1", 10, 100.0, 150.0, 50.0),
        PortfolioItem("Stock Name 2", 5, 200.0, 250.0, 50.0),
        PortfolioItem("Stock Name 3", 20, 50.0, 75.0, 25.0)
        // Tambahkan lebih banyak item sesuai kebutuhan
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_portfolio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.portfolioContainer)
        recyclerView.layoutManager = LinearLayoutManager(context)
        portfolioAdapter = PortfolioAdapter(portfolioItems)
        recyclerView.adapter = portfolioAdapter
    }
}

data class PortfolioItem(
    val stockName: String,
    val quantity: Int,
    val purchasePrice: Double,
    val currentPrice: Double,
    val profitLoss: Double
)

class PortfolioAdapter(private val items: List<PortfolioItem>) : RecyclerView.Adapter<PortfolioAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.portfolio_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.tvStockName.text = item.stockName
        holder.tvStockQuantity.text = "Quantity: ${item.quantity}"
        holder.tvStockPrice.text = "Price: $${item.purchasePrice}"
        holder.tvStockCurrentValue.text = "Current Value: $${item.currentPrice}"
        holder.tvStockProfitLoss.text = "Profit/Loss: $${item.profitLoss}"
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvStockName: TextView = itemView.findViewById(R.id.tvStockName)
        val tvStockQuantity: TextView = itemView.findViewById(R.id.tvStockQuantity)
        val tvStockPrice: TextView = itemView.findViewById(R.id.tvStockPrice)
        val tvStockCurrentValue: TextView = itemView.findViewById(R.id.tvStockCurrentValue)
        val tvStockProfitLoss: TextView = itemView.findViewById(R.id.tvStockProfitLoss)
    }
}
