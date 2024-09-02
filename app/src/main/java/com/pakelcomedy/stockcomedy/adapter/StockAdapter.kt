package com.pakelcomedy.stockcomedy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pakelcomedy.stockcomedy.databinding.PortfolioItemBinding
import com.pakelcomedy.stockcomedy.model.Stock
import com.pakelcomedy.stockcomedy.R

class StockAdapter(private val stockList: List<Stock>) :
    RecyclerView.Adapter<StockAdapter.StockViewHolder>() {

    inner class StockViewHolder(private val binding: PortfolioItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(stock: Stock) {
            binding.tvStockName.text = stock.name
            binding.tvStockQuantity.text = "Quantity: ${stock.quantity}"
            binding.tvStockPrice.text = "Price: $${stock.price}"
            binding.tvStockCurrentValue.text = "Current Value: $${stock.currentValue}"

            val profitLossText = "Profit/Loss: $${stock.profitLoss}"
            binding.tvStockProfitLoss.text = profitLossText
            binding.tvStockProfitLoss.setTextColor(
                if (stock.profitLoss >= 0) {
                    binding.root.context.getColor(R.color.holo_green_light)
                } else {
                    binding.root.context.getColor(R.color.holo_red_light)
                }
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockViewHolder {
        val binding = PortfolioItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StockViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StockViewHolder, position: Int) {
        val stock = stockList[position]
        holder.bind(stock)
    }

    override fun getItemCount(): Int {
        return stockList.size
    }
}
