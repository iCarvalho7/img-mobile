package br.com.isaias.img.ui.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.isaias.img.R
import br.com.isaias.img.databinding.FragmentSignUpBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 * Use the [SignUpFragment()] to
 * create an instance of this fragment.
 */
class SignUpFragment : Fragment() {

    private val signUpViewModel : SignUpViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return FragmentSignUpBinding.inflate(inflater, container, false).let {
            it.lifecycleOwner = viewLifecycleOwner
            it.viewModel = signUpViewModel
            it.root
        }
    }
}