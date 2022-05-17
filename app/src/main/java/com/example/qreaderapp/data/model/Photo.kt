package com.example.qreaderapp.data.model

import android.graphics.Bitmap
import android.os.Parcelable
import java.io.Serializable

data class Photo(
    val photoBitmap: Bitmap,
    val base64: String
): Serializable