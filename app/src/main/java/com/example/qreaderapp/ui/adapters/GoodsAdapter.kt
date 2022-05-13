package com.example.qreaderapp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.qreaderapp.data.model.Bien
import com.example.qreaderapp.databinding.ItemBienBinding
import com.github.islamkhsh.CardSliderAdapter

class GoodsAdapter(private val goods: List<Bien>, private val context: Context): CardSliderAdapter<GoodsAdapter.GoodViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodViewHolder {
        val view = ItemBienBinding.inflate(LayoutInflater.from(context),parent, false)
        return GoodViewHolder(view)
    }

    override fun bindVH(holder: GoodViewHolder, position: Int) {
        holder.binData(goods[position])
    }

    override fun getItemCount(): Int {
        return goods.size
    }

    class GoodViewHolder(val binding: ItemBienBinding): RecyclerView.ViewHolder(binding.root) {
        fun binData(bien: Bien){
            with(binding){
                tvNumInv.text = bien.numeroInventario
                tvSerieItem.text = bien.serie
                tvMarcaItem.text = bien.marca
                tvModeloItem.text = bien.modelo
                tvMacaddrItem.text = bien.macAddress
            }

        }
    }
}