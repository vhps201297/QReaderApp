package com.example.qreaderapp.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.qreaderapp.data.model.Bien
import com.example.qreaderapp.data.model.Util
import com.example.qreaderapp.databinding.ActivityGoodsDetailBinding
import com.example.qreaderapp.ui.adapters.GoodsAdapter

class GoodsDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGoodsDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoodsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Detalle del bien"

        val bienes = ArrayList<Bien>().apply {
            add(Bien("02-I180000064-72839","HP","ProDesk 400 G5 SFF", "MXL9364BGK","DCA5F486B494",null,"PRODESK 400 G5 SFF, MARCA HP, PROCESADOR INTEL CORE I7-8700, 8GB DE MEMORIA RAM, 500 GB HDD, V214A MONITOR 20.7”"))
            add(Bien("DGTI-NA-02484","HP","KBAR211", "PAB6ST","DCA5F4877987",null,"TECLADO"))
            add(Bien("DGTI-NA-02471","LENOVO","LN8A6NH11B", "CB6203214","N/A",null,"DVD"))
        }
        binding.cardSliderVp.adapter = GoodsAdapter(bienes, this)

    }
}