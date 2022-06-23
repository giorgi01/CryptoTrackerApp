package com.example.cryptotrackerapp

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptotrackerapp.adapters.CoinRateRecyclerAdapter
import com.example.cryptotrackerapp.api.dto.CoinApiData
import com.example.cryptotrackerapp.api.dto.CoinRate
import com.example.cryptotrackerapp.api.dto.RestClient
import com.example.cryptotrackerapp.broadcastReceiver.BroadCastReceiver
import com.example.cryptotrackerapp.broadcastReceiver.NotificationManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var broadCastReceiver:BroadCastReceiver
//    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NotificationManager.channel(this)

        broadCastReceiver = BroadCastReceiver()

        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(broadCastReceiver, it)
        }

//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        RestClient.initClient()

        RestClient.coinApiApi.getCoinRate("BTC", "F8692860-9D7C-4A02-A4EE-7177355AC220").enqueue(object : Callback<CoinApiData<CoinRate>> {
            override fun onResponse(
                call: Call<CoinApiData<CoinRate>>,
                response: Response<CoinApiData<CoinRate>>
            ) {

                if(response.isSuccessful){
                    response.body()?.let {
                        recyclerView.adapter = CoinRateRecyclerAdapter(it.rates)
                        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    }
                }
            }

            override fun onFailure(call: Call<CoinApiData<CoinRate>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }
}