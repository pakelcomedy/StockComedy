package com.pakelcomedy.stockcomedy.repository

import com.pakelcomedy.stockcomedy.database.AppDatabase
import com.pakelcomedy.stockcomedy.database.StockEntity
import kotlinx.coroutines.flow.Flow

class StockRepository(private val database: AppDatabase) {

    private val stockDao = database.stockDao()

    // Menyisipkan saham baru ke dalam database
    suspend fun insertStock(stock: StockEntity) {
        stockDao.insert(stock)
    }

    // Memperbarui saham yang ada di database
    suspend fun updateStock(stock: StockEntity) {
        stockDao.update(stock)
    }

    // Menghapus saham dari database
    suspend fun deleteStock(stock: StockEntity) {
        stockDao.delete(stock)
    }

    // Mengambil semua saham dari database
    fun getAllStocks(): Flow<List<StockEntity>> {
        return stockDao.getAllStocks()
    }

    // Mengambil saham berdasarkan ID dari database
    suspend fun getStockById(id: Int): StockEntity? {
        return stockDao.getStockById(id)
    }

    // Mengambil saham berdasarkan nama dari database
    suspend fun getStockByName(name: String): StockEntity? {
        return stockDao.getStockByName(name)
    }
}
