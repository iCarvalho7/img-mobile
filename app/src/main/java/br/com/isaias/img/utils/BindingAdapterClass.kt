package br.com.isaias.img.utils

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

object BindingAdapterClass {

    @BindingAdapter("app:hintCleared")
    @JvmStatic
    fun clearHintWhenTextIsTyped(editText: TextInputEditText, hint: String) {
        editText.hint = hint
        editText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus)
                editText.hint = ""
            else
                editText.hint = hint
        }
    }
}