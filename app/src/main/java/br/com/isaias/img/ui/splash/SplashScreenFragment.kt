package br.com.isaias.img.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.isaias.img.databinding.FragSplashBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragSplashBinding.inflate(inflater, container, false).root
    }

    override fun onResume() {
        super.onResume()
        GlobalScope.launch {
            delay(3000)
            requireActivity().finish()
        }
    }
}