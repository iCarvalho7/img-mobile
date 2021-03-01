package br.com.isaias.img.ui.photos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.isaias.img.R
import br.com.isaias.img.data.model.Photo
import br.com.isaias.img.databinding.DialogFragSingupSuccessBinding
import br.com.isaias.img.databinding.ItemPhotosBinding
import com.bumptech.glide.Glide

class PhotosAdapter :
    ListAdapter<Photo, PhotosAdapter.PhotosAdapterViewHolder>(PhotosDiffCallback()) {

    class PhotosAdapterViewHolder(private val binding: ItemPhotosBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Photo) {
            Glide.with(binding.root)
                .load(item.url)
                .placeholder(R.drawable.app_logo)
                .into(binding.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosAdapterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPhotosBinding.inflate(inflater, parent, false)
        return PhotosAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotosAdapterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PhotosDiffCallback : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo) = oldItem.url == newItem.url
        override fun areContentsTheSame(oldItem: Photo, newItem: Photo) = oldItem == newItem
    }
}