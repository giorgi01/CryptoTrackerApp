package com.example.cryptotrackerapp

import android.app.Application
import androidx.room.Room
import com.example.cryptotrackerapp.data.CryptoCoinDatabase

class App : Application() {

    lateinit var db: CryptoCoinDatabase

    companion object{
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

        db = Room.databaseBuilder(
            applicationContext,
            CryptoCoinDatabase::class.java,
            "CryptoCoinsDb"
        ).allowMainThreadQueries().build()
    }

}