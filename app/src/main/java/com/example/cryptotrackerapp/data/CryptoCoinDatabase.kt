package com.example.cryptotrackerapp.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CryptoCoin::class], version = 1)
abstract class CryptoCoinDatabase : RoomDatabase() {
    abstract fun getCryptoCoinDao() : CryptoCoinDao
}