package br.com.isaias.img.utils

import androidx.annotation.StringRes
import androidx.core.widget.addTextChangedListener
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

    @JvmStatic
    @BindingAdapter("error")
    fun setError(textInputLayout: TextInputLayout, @StringRes errorStringRes: Int?) {
        val context = textInputLayout.context

        textInputLayout.error = if (errorStringRes != null) {
            context.getString(errorStringRes)
        } else {
            null
        }
    }

    @JvmStatic
    @BindingAdapter("clearErrorAsTyping")
    fun setClearErrorAsTyping(textInputLayout: TextInputLayout, isEnabled: Boolean) {
        if (isEnabled)
            textInputLayout.editText?.addTextChangedListener { textInputLayout.error = null }
    }

    @JvmStatic
    @BindingAdapter("setDatesMask")
    fun setDatesMask(textInputEditText: TextInputEditText, isEnabled: Boolean) {
        if (isEnabled) {
            textInputEditText.addTextChangedListener(TextWatcherDates(textInputEditText))
        }
    }
}