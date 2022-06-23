package com.example.cryptotrackerapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptotrackerapp.R
import com.example.cryptotrackerapp.api.dto.CoinRate
import com.squareup.picasso.Picasso

class CoinRateRecyclerAdapter(private val coins: List<CoinRate>): RecyclerView.Adapter<CoinRateRecyclerAdapter.CarViewHolder>() {
    class CarViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private val image: ImageView = itemView.findViewById(R.id.imageView)
        private val nameView: TextView = itemView.findViewById(R.id.textView)
        private val rateView: TextView = itemView.findViewById(R.id.textView2)

        fun onBind(coin: CoinRate){
            Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/d/d0/Dogecoin_Logo.png").into(image)
            nameView.text = coin.asset_id_quote
            rateView.text = coin.rate.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_rate, parent, false)
        return CarViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.onBind(coins[position])
    }

    override fun getItemCount(): Int {
        return coins.size
    }
}