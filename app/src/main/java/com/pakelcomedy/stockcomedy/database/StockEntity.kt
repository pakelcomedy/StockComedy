package com.pakelcomedy.stockcomedy.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stock_table")
data class StockEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val quantity: Int,
    val purchasePrice: Double,
    val currentPrice: Double
)
