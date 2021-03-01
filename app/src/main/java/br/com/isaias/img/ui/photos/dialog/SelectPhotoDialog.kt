package br.com.isaias.img.ui.photos.dialog

import android.app.Dialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import br.com.isaias.img.databinding.DialogFragSelectPhotoBinding
import br.com.isaias.img.ui.photos.PhotosViewModel
import br.com.isaias.img.utils.options
import com.bumptech.glide.Glide
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.*


class SelectPhotoDialog(private val viewModel: PhotosViewModel, private val url: String) :
    DialogFragment() {

    private lateinit var binding: DialogFragSelectPhotoBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        val inflater = requireActivity().layoutInflater

        val view = DialogFragSelectPhotoBinding.inflate(inflater, null, false).let { bind ->
            Glide.with(requireContext())
                .applyDefaultRequestOptions(options)
                .load(url)
                .into(bind.dialogPhoto)
            binding = bind
            bind.dialog = this
            bind.root
        }
        builder.setView(view)
        return builder.create()
            .apply { window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT)) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListeners()
    }

    fun sharePhoto() {
        val share = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, url)
            type = "text/plain"
        }
        startActivity(share)
    }

    fun downloadPhoto() {
        try {
            val path = requireContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            val file = File(path, "imgApp_${System.currentTimeMillis()}.jpg")
            val bitmap = (binding.dialogPhoto.drawable as BitmapDrawable).bitmap

            FileOutputStream(file).use { out ->
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)
            }
            MediaStore.Images.Media.insertImage(
                requireContext().contentResolver,
                file.absolutePath,
                file.name,
                file.name
            )
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun setUpListeners() {
        binding.dialogPhotoFavorite.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked)
                viewModel.favoritePhoto()
        }
    }
}