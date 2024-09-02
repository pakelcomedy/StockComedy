package com.pakelcomedy.stockcomedy.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.pakelcomedy.stockcomedy.databinding.FragmentWorkTapBinding
import com.pakelcomedy.stockcomedy.viewmodel.WorkTapViewModel

class WorkTapFragment : Fragment() {

    private var _binding: FragmentWorkTapBinding? = null
    private val binding get() = _binding!!

    private val workTapViewModel: WorkTapViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWorkTapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observasi perubahan saldo dari ViewModel
        workTapViewModel.currentBalance.observe(viewLifecycleOwner) { balance ->
            binding.tvCurrentBalance.text = "Current Balance: $$balance"
        }

        // Setup tombol tap untuk menghasilkan uang
        binding.btnTapForMoney.setOnClickListener {
            workTapViewModel.incrementBalance()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}