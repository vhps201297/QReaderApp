package com.example.qreaderapp.data.model

import android.graphics.Bitmap
import android.net.MacAddress

data class Bien(
    val numeroInventario: String,
    val marca: String,
    val modelo: String,
    val serie: String,
    val macAddress: String,
    var imgBitmap: Bitmap?,
    val descripcion: String
)