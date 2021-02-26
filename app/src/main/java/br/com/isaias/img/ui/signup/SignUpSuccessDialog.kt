package br.com.isaias.img.ui.signup

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import br.com.isaias.img.R
import br.com.isaias.img.databinding.DialogFragSingupSuccessBinding
import br.com.isaias.img.utils.setWindowFullScreen

class SignUpSuccessDialog : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).let {
            it.setWindowFullScreen()
            it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return DialogFragSingupSuccessBinding.inflate(inflater, container, false).let {
            it.dialog = this
            it.root
        }
    }

    fun navigateToHome(){
        this.dismiss()
    }
}