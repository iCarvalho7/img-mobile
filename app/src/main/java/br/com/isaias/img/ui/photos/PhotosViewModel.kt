package br.com.isaias.img.ui.photos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.isaias.img.data.repository.PhotoRepository
import br.com.isaias.img.data.repository.UserRepository
import kotlinx.coroutines.launch

class PhotosViewModel(private val photoRepository: PhotoRepository) : ViewModel() {

    fun sharePhoto() {
    }

    fun downloadPhoto() {
        viewModelScope.launch {

        }
    }

    fun favoritePhoto() {

    }
}