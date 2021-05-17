package br.com.isaias.img.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val firstName: String,
    val lastName : String,
    val username : String,
    val birthDate : String,
    val email: String,
    val password: String
) : Parcelable