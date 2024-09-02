package com.pakelcomedy.stockcomedy.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Model class for representing a stock entity in the app.
 */
@Entity(tableName = "stocks")
data class Stock(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0, // Unique identifier for the stock

    @NonNull
    val name: String, // Name of the stock

    val quantity: Int, // Quantity of the stock owned

    val price: Double, // Price per unit of the stock

    val currentValue: Double // Current market value of the stock
) {
    /**
     * Calculate the profit or loss for the stock.
     */
    val profitLoss: Double
        get() = (currentValue - price) * quantity
}
