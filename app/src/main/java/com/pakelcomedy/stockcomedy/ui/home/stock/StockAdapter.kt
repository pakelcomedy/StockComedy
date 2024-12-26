package com.pakelcomedy.stockcomedy.ui.home.stock

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pakelcomedy.stockcomedy.R
import com.pakelcomedy.stockcomedy.data.model.Stock

class StockAdapter(
    private val stockList: List<Stock>,
    private val itemClickListener: (String) -> Unit // Lambda to handle item click
) : RecyclerView.Adapter<StockAdapter.StockViewHolder>() {

    class StockViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val stockName: TextView = view.findViewById(R.id.stockName)
        val stockPrice: TextView = view.findViewById(R.id.stockPrice)
        val stockChange: TextView = view.findViewById(R.id.stockChange)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_stock, parent, false)
        return StockViewHolder(view)
    }

    override fun onBindViewHolder(holder: StockViewHolder, position: Int) {
        val stock = stockList[position]
        holder.stockName.text = stock.name
        holder.stockPrice.text = stock.price
        holder.stockChange.text = stock.change
        holder.stockChange.setTextColor(
            if (stock.change.startsWith("-")) Color.RED else Color.GREEN
        )

        holder.itemView.setOnClickListener {
            itemClickListener(stock.name) // Trigger the lambda
        }
    }

    override fun getItemCount(): Int {
        return stockList.size
    }
}