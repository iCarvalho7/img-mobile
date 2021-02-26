package br.com.isaias.img.ui.ui_components

import android.content.Context
import android.util.AttributeSet
import br.com.isaias.img.R
import com.google.android.material.button.MaterialButton

class FacebookMaterialButton(context: Context, attrs : AttributeSet) : MaterialButton(context) {
    private var buttonTitle : String = "Facebook"
    private var facebookIcon : Int = R.drawable.ic_facebook_white

    init {
        context.obtainStyledAttributes(attrs, R.styleable.GoogleMaterialButton).apply {
            icon = context.resources.getDrawable(facebookIcon)
            text = buttonTitle
            cornerRadius = 60
            isAllCaps = false
            setBackgroundColor(context.resources.getColor(R.color.facebook_dark_blue))
        }.recycle()
    }
}