package com.pakelcomedy.stockcomedy.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context

// Menandakan bahwa kelas ini adalah database Room
@Database(entities = [StockEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    // Mendeklarasikan DAO
    abstract fun stockDao(): StockDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // Fungsi untuk mendapatkan instance dari database
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "stock_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}