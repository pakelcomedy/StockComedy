package com.pakelcomedy.stockcomedy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pakelcomedy.stockcomedy.database.StockEntity
import com.pakelcomedy.stockcomedy.repository.StockRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class PortfolioViewModel(private val repository: StockRepository) : ViewModel() {

    // Mengambil semua saham dari repository
    val allStocks: Flow<List<StockEntity>> = repository.getAllStocks()

    // Mendapatkan saldo trading saat ini (berdasarkan harga pembelian)
    val tradingBalance: Flow<Double> = allStocks.map { stocks ->
        stocks.sumOf { stock -> stock.purchasePrice * stock.quantity } // Menggunakan `purchasePrice` dan `quantity`
    }

    // Mendapatkan ekuitas total (berdasarkan harga saat ini)
    val totalEquity: Flow<Double> = allStocks.map { stocks ->
        stocks.sumOf { stock -> stock.currentPrice * stock.quantity } // Menggunakan `currentPrice` dan `quantity`
    }

    // Mendapatkan laba/rugi (berdasarkan harga saat ini vs. harga pembelian)
    val profitLoss: Flow<Double> = allStocks.map { stocks ->
        stocks.sumOf { stock -> (stock.currentPrice - stock.purchasePrice) * stock.quantity } // Menggunakan `currentPrice`, `purchasePrice`, dan `quantity`
    }

    // Menyisipkan saham baru ke dalam repository
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