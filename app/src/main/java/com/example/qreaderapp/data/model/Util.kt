package com.example.qreaderapp.data.model

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64

object Util {
    fun base64ToBitmap(strBase64: String): Bitmap {
        val decodedString: ByteArray = Base64.decode(strBase64, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
    }
}