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
            add(Bien("123456777","Lenovo1","X13122", "123123123","12:12:12:12:12:12",null,"descripción prueba1"))
            add(Bien("123456767","Lenovo2","X13122", "12312313323","22:12:12:12:12:12",null,"descripción prueba 2"))
            add(Bien("123456768","Lenovo3","X1312", "12312313323","32:12:12:12:12:12",null,"descripción prueba 3"))
        }
        binding.cardSliderVp.adapter = GoodsAdapter(bienes, this)

    }
}