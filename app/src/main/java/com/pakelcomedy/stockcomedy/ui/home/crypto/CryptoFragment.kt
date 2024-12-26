package com.pakelcomedy.stockcomedy.ui.home.crypto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pakelcomedy.stockcomedy.data.model.Crypto
import com.pakelcomedy.stockcomedy.R

class CryptoFragment : Fragment() {

    private lateinit var cryptoRecyclerView: RecyclerView
    private lateinit var cryptoAdapter: CryptoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crypto, container, false)
        cryptoRecyclerView = view.findViewById(R.id.cryptoRecyclerView)

        val cryptoList = listOf(
            Crypto("Bitcoin", "$28,000", "+5%"),
            Crypto("Ethereum", "$1,800", "-3%"),
            Crypto("BNB", "$250", "+1%"),
            Crypto("Cardano", "$0.45", "+2.5%")
        )

        cryptoAdapter = CryptoAdapter(cryptoList)
        cryptoRecyclerView.adapter = cryptoAdapter
        cryptoRecyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }
}