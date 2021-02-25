package br.com.isaias.img.utils

import android.text.Editable
import android.text.TextWatcher
import com.google.android.material.textfield.TextInputEditText

class TextWatcherDates(private val editText: TextInputEditText) : TextWatcher {
    var edited = false
    private val dividerCharacter = "/"

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun afterTextChanged(s: Editable?) {}

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        if (edited) {
            edited = false
            return
        }

        var working = editText.text.toString()

        working = manageDateDivider(working, 2, start, before)
        working = manageDateDivider(working, 5, start, before)
        edited = true

        editText.setText(working)
        editText.setSelection(editText.text!!.length)
    }

    private fun manageDateDivider(
        working: String,
        position: Int,
        start: Int,
        before: Int
    ): String {
        if (working.length == position) {
            return if (before <= position && start < position)
                working + dividerCharacter
            else
                working.dropLast(1)
        }
        return working
    }
}