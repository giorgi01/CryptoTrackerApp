package com.example.cryptotrackerapp.api.dto

import com.google.gson.annotations.SerializedName
import org.json.JSONArray
import java.util.Date

data class CoinApiData<T>(
    @SerializedName("asset_id_base")
    val assetIdBase: String,
    val rates: List<CoinRate>
)

data class CoinRate (
    val asset_id_quote: String,
    val rate: Double,
    val time: Date,
)