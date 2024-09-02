package com.pakelcomedy.stockcomedy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pakelcomedy.stockcomedy.database.StockEntity
import com.pakelcomedy.stockcomedy.repository.StockRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class StockListViewModel(private val repository: StockRepository) : ViewModel() {

    // Flow to observe the list of stocks
    val allStocks: Flow<List<StockEntity>> = repository.getAllStocks()

    // Fetch stocks method
    fun fetchStocks() {
        viewModelScope.launch {
            // Collect the flow to refresh data if needed
            allStocks.collect { stockList ->
                // Handle stockList here if needed
                // Example: Update UI or trigger additional logic
            }
        }
    }

    fun insertStock(stock: StockEntity) = viewModelScope.launch {
        repository.insertStock(stock)
    }

    fun updateStock(stock: StockEntity) = viewModelScope.launch {
        repository.updateStock(stock)
    }

    fun deleteStock(stock: StockEntity) = viewModelScope.launch {
        repository.deleteStock(stock)
    }

    suspend fun getStockById(id: Int): StockEntity? {
        return repository.getStockById(id)
    }

    suspend fun getStockByName(name: String): StockEntity? {
        return repository.getStockByName(name)
    }
}