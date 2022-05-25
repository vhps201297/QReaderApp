package com.example.qreaderapp.ui.dialog

import android.app.Dialog
import androidx.appcompat.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.qreaderapp.data.model.Photo
import com.example.qreaderapp.databinding.ItemVisorPhotoBinding

class PhotoDialog(val photo: Photo): DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val view = ItemVisorPhotoBinding.inflate(requireActivity().layoutInflater)
            view.imgPhotoVisor.setImageBitmap(photo.photoBitmap)
            view.fabCheckVisor.setOnClickListener { this.dismiss() }
            builder.setView(view.root)
            builder.create()

        } ?: throw IllegalStateException("Activity cannot be null")
        //return super.onCreateDialog(savedInstanceState)
    }
}