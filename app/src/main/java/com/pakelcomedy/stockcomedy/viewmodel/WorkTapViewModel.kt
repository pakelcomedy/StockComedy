package com.pakelcomedy.stockcomedy.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pakelcomedy.stockcomedy.repository.StockRepository
import kotlinx.coroutines.launch

class WorkTapViewModel(private val repository: StockRepository) : ViewModel() {

    // LiveData untuk saldo saat ini
    private val _currentBalance = MutableLiveData<Int>(0)
    val currentBalance: LiveData<Int> get() = _currentBalance

    // Fungsi untuk menambahkan saldo saat tombol tap ditekan
    fun tapToEarn() {
        viewModelScope.launch {
            // Mengambil saldo saat ini dari repository atau database
            val current = _currentBalance.value ?: 0
            // Menambahkan saldo dengan nilai tertentu (misalnya $1 per tap)
            val updatedBalance = current + 1
            // Memperbarui saldo di repository
            repository.updateBalance(updatedBalance)
            // Memperbarui LiveData
            _currentBalance.value = updatedBalance
        }
    }

    // Mengambil saldo awal dari repository
    fun fetchInitialBalance() {
        viewModelScope.launch {
            val initialBalance = repository.getBalance()
            _currentBalance.value = initialBalance
        }
    }
}
