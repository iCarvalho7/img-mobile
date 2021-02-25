package br.com.isaias.img.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun View.longSnackBar(@StringRes resId: Int){
    Snackbar.make(this, resId, Snackbar.LENGTH_LONG).show()
}