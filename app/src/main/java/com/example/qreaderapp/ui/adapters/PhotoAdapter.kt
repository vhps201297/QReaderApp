package com.example.qreaderapp.ui.adapters

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.qreaderapp.data.model.Photo
import com.example.qreaderapp.databinding.ItemPhotoCaptureBinding
import com.github.islamkhsh.CardSliderAdapter
import java.io.Serializable

class PhotoAdapter(var listPhotos: List<Photo>, val listener: ItemCardListener): RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>(), Serializable {

    /*
    override fun bindVH(holder: PhotoViewHolder, position: Int) {
        holder.bindData(listPhotos[position], listener)
    }*/

    override fun getItemCount() = listPhotos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = ItemPhotoCaptureBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PhotoViewHolder(view)
    }
    class PhotoViewHolder(val binding: ItemPhotoCaptureBinding): RecyclerView.ViewHolder(binding.root) {

        fun bindData(photo: Photo, listener: ItemCardListener){
            binding.imgPhoto.setImageBitmap(photo.photoBitmap)
            binding.fabDeletePhoto.setOnClickListener { listener.removePhoto(photo = photo) }
        }
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bindData(listPhotos[position], listener)
    }

}

interface ItemCardListener{
    fun removePhoto(photo: Photo)
}