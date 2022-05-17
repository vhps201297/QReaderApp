package com.example.qreaderapp.ui.views

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.example.qreaderapp.R
import com.example.qreaderapp.data.model.Photo
import com.example.qreaderapp.data.model.Util
import com.example.qreaderapp.databinding.ActivityGoodsCaptureBinding
import com.example.qreaderapp.ui.adapters.ItemCardListener
import com.example.qreaderapp.ui.adapters.PhotoAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class GoodsCaptureActivity : AppCompatActivity(), ItemCardListener {
    private val REQUEST_CODE_CAMERA = 20
    companion object{
        private const val TAG = "GoodsCaptureActivity"
        private var listPhotos = ArrayList<Photo>()
    }
    private val adapterPhoto = PhotoAdapter(listPhotos, this)
    private lateinit var binding: ActivityGoodsCaptureBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoodsCaptureBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.sliderPhotoCapture.adapter = adapterPhoto
        title = "Captura de datos"

        val items = listOf("Víctor Hugo Pólito Seba", "Daniel Ramos Limón", "Jonatan Michael López Colín")
        val arrayAdapter = ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        arrayAdapter.addAll(items)
        (binding.spinnerTilUser.editText as AutoCompleteTextView).setAdapter(arrayAdapter)
    }

    fun onClickCapturePicture(view: View) {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePicture ->
            takePicture.resolveActivity(packageManager).also {
                startActivityForResult(takePicture, REQUEST_CODE_CAMERA)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE_CAMERA && resultCode == RESULT_OK){
            val bitmapPhoto = data?.extras?.get("data") as Bitmap
            listPhotos.add(Photo(bitmapPhoto, Util.bitmapToBase64(bitmapPhoto)))
            adapterPhoto.notifyDataSetChanged()
            //binding.imgPhotoCapture.visibility = View.VISIBLE
            //binding.imgPhotoCapture.setImageBitmap(bitmapPhoto)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun removePhoto(photo: Photo) {
        listPhotos.remove(photo)
        adapterPhoto.notifyDataSetChanged()
    }

    fun onClickMarca(view: View) {
        Log.e(TAG, "click marca")
        val marcas = arrayOf("LENOVO", "HP", "DELL")
        MaterialAlertDialogBuilder(this)
            .setTitle("MARCAS")
            .setPositiveButton("Aceptar") { dialog, which ->
                Log.e(TAG, "positive button which: $which")
            }
            .setSingleChoiceItems(marcas,1){ dialog, which ->
                Log.e(TAG, "single choice: $which")
                binding.edtxtMarcaCaptura.setText(marcas[which])
            }
            .show()
    }

    fun onClickModelo(view: View) {

        Log.e(TAG, "click marca")
        val marcas = arrayOf("ProDesk 400 G5 SFF", "KBAR211", "674316", "LN8A6NH11B", "KBAR211", "PS8402A")
        MaterialAlertDialogBuilder(this)
            .setTitle("MODELOS")
            .setPositiveButton("Aceptar") { dialog, which ->
                Log.e(TAG, "positive button which: $which")
            }
            .setSingleChoiceItems(marcas,1){ dialog, which ->
                Log.e(TAG, "single choice: $which")
                binding.edtxtModeloCaptura.setText(marcas[which])
            }
            .show()
    }

}