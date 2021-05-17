package br.com.isaias.img.data.model.response

import android.os.Parcelable
import br.com.isaias.img.data.model.User
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserResponse(
    val user : User,
    val token : String
) : Parcelable