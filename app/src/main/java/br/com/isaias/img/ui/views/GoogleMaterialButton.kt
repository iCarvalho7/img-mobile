package br.com.isaias.img.ui.views

import android.content.Context
import android.util.AttributeSet
import br.com.isaias.img.R
import com.google.android.material.button.MaterialButton

class GoogleMaterialButton(context: Context, attrs: AttributeSet) : MaterialButton(context) {

    private var buttonTitle : String = "Google"
    private var googleIcon : Int = R.drawable.ic_google_white

    init {
        context.obtainStyledAttributes(attrs, R.styleable.GoogleMaterialButton).apply {
            icon = context.resources.getDrawable(googleIcon)
            text = buttonTitle
            cornerRadius = 60
            isAllCaps = false
            setBackgroundColor(context.resources.getColor(R.color.google_red))
        }.recycle()
    }
}