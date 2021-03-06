package br.com.isaias.img.ui.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import br.com.isaias.img.databinding.FragmentSignUpBinding
import br.com.isaias.img.utils.setUserInteractionEnabled
import br.com.isaias.img.value_obj.Status
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        signUpViewModel.userCreated.observe(viewLifecycleOwner, Observer {
            setUserInteractionEnabled(true)
            when (it.status) {
                Status.LOADING -> setUserInteractionEnabled(false)
                Status.ERROR -> setUserInteractionEnabled(true)
                Status.SUCCESS -> SignUpSuccessDialog().show(childFragmentManager, "monobisexual")
            }
        })
    }
}