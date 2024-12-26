package com.pakelcomedy.stockcomedy.ui.home.crypto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pakelcomedy.stockcomedy.R
import com.pakelcomedy.stockcomedy.data.model.Crypto

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

        // Set the adapter with a click listener
        cryptoAdapter = CryptoAdapter(cryptoList) { cryptoName ->
            onCryptoItemClicked(cryptoName)
        }
        cryptoRecyclerView.adapter = cryptoAdapter
        cryptoRecyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }

    // Handle the item click and navigate to the ChartFragment
    private fun onCryptoItemClicked(cryptoName: String) {
        val bundle = Bundle()
        bundle.putBoolean("isFromCrypto", true) // Mark that we are coming from CryptoFragment
        findNavController().navigate(R.id.action_cryptoFragment_to_chartFragment, bundle)
    }
}