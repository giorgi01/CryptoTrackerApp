package com.example.cryptotrackerapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CryptoCoinDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addCryptoCoin(activity: CryptoCoin);

    @Query("SELECT * FROM crypto_coins")
    fun readAllData(): List<CryptoCoin>
}