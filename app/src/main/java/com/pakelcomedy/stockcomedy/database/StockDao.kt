package com.pakelcomedy.stockcomedy.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Delete
import kotlinx.coroutines.flow.Flow

@Dao
interface StockDao {

    // Menyisipkan saham baru atau memperbarui yang sudah ada
    @Insert
    suspend fun insert(stock: StockEntity)

    // Memperbarui saham yang sudah ada
    @Update
    suspend fun update(stock: StockEntity)

    // Menghapus saham berdasarkan ID
    @Delete
    suspend fun delete(stock: StockEntity)

    // Mengambil semua saham dari database
    @Query("SELECT * FROM stock_table")
    fun getAllStocks(): Flow<List<StockEntity>>

    // Mengambil saham berdasarkan ID
    @Query("SELECT * FROM stock_table WHERE id = :id")
    suspend fun getStockById(id: Int): StockEntity?

    // Mengambil saham berdasarkan nama
    @Query("SELECT * FROM stock_table WHERE name = :name")
    suspend fun getStockByName(name: String): StockEntity?
}