package com.pakelcomedy.stockcomedy.ui.portfolio.crypto

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pakelcomedy.stockcomedy.R
import com.pakelcomedy.stockcomedy.data.model.CryptoPortfolio

class CryptoPortfolioAdapter(private val cryptoList: List<CryptoPortfolio>) :
    RecyclerView.Adapter<CryptoPortfolioAdapter.CryptoViewHolder>() {

    class CryptoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cryptoName: TextView = view.findViewById(R.id.cryptoName)
        val cryptoValue: TextView = view.findViewById(R.id.cryptoValue)
        val cryptoPnL: TextView = view.findViewById(R.id.cryptoPnL)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_crypto_portofolio, parent, false) // Use correct XML file name
        return CryptoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        val crypto = cryptoList[position]
        holder.cryptoName.text = crypto.name
        holder.cryptoValue.text = crypto.value
        holder.cryptoPnL.text = crypto.pnl

        // Set text color based on PnL value (Profit or Loss)
        holder.cryptoPnL.setTextColor(
            if (crypto.pnl.contains("-")) Color.RED else Color.GREEN
        )
    }

    override fun getItemCount(): Int = cryptoList.size
}