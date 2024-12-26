package com.pakelcomedy.stockcomedy.ui.earnmoney

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pakelcomedy.stockcomedy.databinding.FragmentEarnMoneyBinding

class EarnMoneyFragment : Fragment() {

    private var _binding: FragmentEarnMoneyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflating layout using ViewBinding
        _binding = FragmentEarnMoneyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set initial cash balance value
        binding.cashBalanceValue.text = "$0"

        // Handle click on the clickable area below the cashBalanceContainer
        binding.clickableArea.setOnClickListener {
            // Logic for what happens when the user clicks the area
            updateCashBalance(1) // Example: Increase by $5
        }
    }

    private fun updateCashBalance(amount: Int) {
        // Get the current balance and add the earned amount
        val currentBalanceText = binding.cashBalanceValue.text.toString()
        val currentBalance = currentBalanceText.replace("$", "").toInt()
        val newBalance = currentBalance + amount

        // Update the UI with the new balance
        binding.cashBalanceValue.text = "$$newBalance"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}