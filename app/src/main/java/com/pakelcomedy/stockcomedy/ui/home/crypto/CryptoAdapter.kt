package com.pakelcomedy.stockcomedy.ui.home.crypto

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pakelcomedy.stockcomedy.R
import com.pakelcomedy.stockcomedy.data.model.Crypto

class CryptoAdapter(
    private val cryptoList: List<Crypto>,
    private val itemClickListener: (String) -> Unit // Pass the click listener here
) : RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder>() {

    class CryptoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cryptoName: TextView = view.findViewById(R.id.cryptoName)
        val cryptoPrice: TextView = view.findViewById(R.id.cryptoPrice)
        val cryptoChange: TextView = view.findViewById(R.id.cryptoChange)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_crypto, parent, false)
        return CryptoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        val crypto = cryptoList[position]
        holder.cryptoName.text = crypto.name
        holder.cryptoPrice.text = crypto.price
        holder.cryptoChange.text = crypto.change
        holder.cryptoChange.setTextColor(
            if (crypto.change.startsWith("-")) Color.RED else Color.GREEN
        )

        // Set up the click listener for the item
        holder.itemView.setOnClickListener {
            itemClickListener(crypto.name) // Trigger the click listener with the crypto name
        }
    }

    override fun getItemCount(): Int {
        return cryptoList.size
    }
}