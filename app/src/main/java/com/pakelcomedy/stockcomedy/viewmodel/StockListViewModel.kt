package com.pakelcomedy.stockcomedy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pakelcomedy.stockcomedy.database.StockEntity
import com.pakelcomedy.stockcomedy.repository.StockRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class StockListViewModel(private val repository: StockRepository) : ViewModel() {

    // Mendapatkan semua saham dari repository
    val allStocks: Flow<List<StockEntity>> = repository.getAllStocks()

    // Menyisipkan saham ke repository
    fun insertStock(stock: StockEntity) = viewModelScope.launch {
        repository.insertStock(stock)
    }

    // Memperbarui saham di repository
    fun updateStock(stock: StockEntity) = viewModelScope.launch {
        repository.updateStock(stock)
    }

    // Menghapus saham dari repository
    fun deleteStock(stock: StockEntity) = viewModelScope.launch {
        repository.deleteStock(stock)
    }

    // Mendapatkan saham berdasarkan ID dari repository
    suspend fun getStockById(id: Int): StockEntity? {
        return repository.getStockById(id)
    }

    // Mendapatkan saham berdasarkan nama dari repository
    suspend fun getStockByName(name: String): StockEntity? {
        return repository.getStockByName(name)
    }
}
