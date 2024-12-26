package com.pakelcomedy.stockcomedy.data.model

data class CryptoPortfolio(
    val name: String,
    val value: String,
    val pnl: String // Ensure this field is correctly passed when creating the object
)