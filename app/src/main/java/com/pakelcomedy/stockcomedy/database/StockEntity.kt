package com.pakelcomedy.stockcomedy.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stock_table")
data class StockEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,  // Auto-generating primary key
    val name: String,  // Stock name or symbol
    val quantity: Int,  // Number of shares owned
    val purchasePrice: Double,  // Original price per share when purchased
    val currentPrice: Double  // Current market price per share
)
