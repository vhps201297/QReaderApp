package com.example.qreaderapp.ui.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.qreaderapp.databinding.ActivityMainBinding
import com.google.zxing.integration.android.IntentIntegrator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun onClickScanner(view: View) {
        val integrator = IntentIntegrator(this)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
        integrator.setPrompt("Coloca el QR al centro de la cámara")
        integrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data)
        if(result != null){
            if (result.contents == null)
                Toast.makeText(this, "Se canceló la lectura", Toast.LENGTH_SHORT).show()
            else {
                startActivity(Intent(this, GoodsDetailActivity::class.java))
                Toast.makeText(this, "Lectura: ${result.contents}", Toast.LENGTH_LONG).show()
            }
        }else
            super.onActivityResult(requestCode, resultCode, data)
    }

    fun onClickCapture(view: View) {
        startActivity(Intent(this, GoodsCaptureActivity::class.java))
    }
}