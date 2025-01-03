package com.pakelcomedy.stockcomedy.ui.portfolio.stock

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pakelcomedy.stockcomedy.R
import com.pakelcomedy.stockcomedy.data.model.StockPortfolio

class StockPortfolioAdapter(
    private val portfolioList: List<StockPortfolio>,
    private val onItemClick: (StockPortfolio) -> Unit // Callback to handle click event
) : RecyclerView.Adapter<StockPortfolioAdapter.PortfolioViewHolder>() {

    class PortfolioViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val stockName: TextView = view.findViewById(R.id.stockName)
        val stockDescription: TextView = view.findViewById(R.id.stockDescription)
        val stockPrice: TextView = view.findViewById(R.id.stockPrice)
        val stockPL: TextView = view.findViewById(R.id.stockPL)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortfolioViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_stock_portofolio, parent, false) // Use the correct XML name
        return PortfolioViewHolder(view)
    }

    override fun onBindViewHolder(holder: PortfolioViewHolder, position: Int) {
        val stock = portfolioList[position]
        holder.stockName.text = stock.name
        holder.stockDescription.text = "PnL"
        holder.stockPrice.text = stock.price
        holder.stockPL.text = stock.pnl

        // Set color based on Profit or Loss
        holder.stockPL.setTextColor(
            if (stock.pnl.contains("Profit")) Color.GREEN else Color.RED
        )

        // Handle item click
        holder.itemView.setOnClickListener {
            onItemClick(stock) // Pass the clicked stock to the callback
        }
    }

    override fun getItemCount(): Int = portfolioList.size
}