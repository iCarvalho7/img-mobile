package br.com.isaias.img.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.isaias.img.databinding.FragmentLoginBinding
import br.com.isaias.img.utils.setUserInteractionEnabled
import br.com.isaias.img.value_obj.Status
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment()] to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    private val viewModel : LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment using biding
        return FragmentLoginBinding.inflate(inflater, container, false).let {
            it.lifecycleOwner = viewLifecycleOwner
            it.viewModel = viewModel
            it.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loggedUser.observe(viewLifecycleOwner, {
            when (it.status) {
                Status.LOADING -> setUserInteractionEnabled(false)
                Status.ERROR -> {
                    //TODO
                }
                Status.SUCCESS -> {
                    //TODO
                }
            }
        })
    }
}