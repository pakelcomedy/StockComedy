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

    // Mendapatkan saldo trading saat ini
    // Misalkan saldo trading disimpan secara terpisah atau bisa dihitung dari saham yang dimiliki
    val tradingBalance: Flow<Double> = allStocks.map { stocks ->
        stocks.sumOf { it.price * it.quantity } // Menghitung saldo trading dari harga dan jumlah saham
    }

    // Mendapatkan ekuitas total
    val totalEquity: Flow<Double> = allStocks.map { stocks ->
        stocks.sumOf { it.currentPrice * it.quantity } // Menghitung ekuitas total berdasarkan harga saat ini
    }

    // Mendapatkan laba/rugi
    val profitLoss: Flow<Double> = allStocks.map { stocks ->
        stocks.sumOf { (it.currentPrice - it.price) * it.quantity } // Menghitung laba/rugi
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