package br.com.isaias.img.ui.photos.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import br.com.isaias.img.databinding.DialogFragSelectPhotoBinding
import br.com.isaias.img.databinding.DialogFragSingupSuccessBinding

class SelectPhotoDialog : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return DialogFragSelectPhotoBinding.inflate(inflater, container, false).let {
            it.root
        }
    }
}