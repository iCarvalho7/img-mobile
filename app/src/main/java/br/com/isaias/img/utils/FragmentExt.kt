package br.com.isaias.img.utils

import android.view.WindowManager
import androidx.fragment.app.Fragment

fun Fragment.setUserInteractionEnabled(isEnabled: Boolean) {
    if (isEnabled) {
        activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    } else {
        view?.clearFocus()
        view?.hideKeyboard()
        activity?.window?.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        )
    }
}