package com.example.cryptotrackerapp.api.dto

import com.example.cryptotrackerapp.api.dto.CoinApiData
import com.example.cryptotrackerapp.api.dto.CoinRate
import retrofit2.Call
import retrofit2.http.*
import java.util.Date

interface CoinApiService {
    @GET("exchangerate/{coinName}")
    fun getCoinRate(@Path("coinName")name: String, @Header("X-CoinAPI-Key")key: String):
            Call<CoinApiData<CoinRate>>
}