package com.pakelcomedy.stockcomedy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class WorkTapFragment : Fragment() {

    private var currentBalance: Int = 0 // Inisialisasi saldo saat ini
    private lateinit var tvCurrentBalance: TextView
    private lateinit var btnTapForMoney: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout untuk fragment ini
        val view = inflater.inflate(R.layout.activity_tap_work, container, false)

        // Inisialisasi komponen UI
        tvCurrentBalance = view.findViewById(R.id.tvCurrentBalance)
        btnTapForMoney = view.findViewById(R.id.btnTapForMoney)

        // Atur listener untuk tombol
        btnTapForMoney.setOnClickListener {
            // Tambah $1 ke saldo saat ini setiap kali tombol ditekan
            currentBalance += 1
            updateBalance()
        }

        // Inisialisasi saldo awal
        updateBalance()

        return view
    }

    // Fungsi untuk memperbarui tampilan saldo
    private fun updateBalance() {
        tvCurrentBalance.text = "Current Balance: $$currentBalance"
    }
}
