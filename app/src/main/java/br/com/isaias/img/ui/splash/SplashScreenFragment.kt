package br.com.isaias.img.ui.splash

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.isaias.img.R
import br.com.isaias.img.databinding.FragmentSplashBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentSplashBinding.inflate(inflater, container, false).root
    }

    override fun onResume() {
        super.onResume()
        Handler().postDelayed ({
            findNavController().navigate(R.id.action_splashScreenFragment_to_loginFragment)
        }, 2000)
    }
}