package com.example.qreaderapp.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.qreaderapp.databinding.ActivityGoodsCaptureBinding

class GoodsCaptureActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGoodsCaptureBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoodsCaptureBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Captura de datos"
    }
}