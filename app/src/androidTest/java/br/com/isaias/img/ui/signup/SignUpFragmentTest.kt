package br.com.isaias.img.ui.signup

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.isaias.img.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.KoinTest

@RunWith(AndroidJUnit4::class)
class SignUpFragmentTest : KoinTest{

    @Before fun testSignUpFragment(){
        val scenario =
            launchFragmentInContainer<SignUpFragment>(themeResId = R.style.Theme_img)
        scenario.moveToState(Lifecycle.State.CREATED)
    }
}