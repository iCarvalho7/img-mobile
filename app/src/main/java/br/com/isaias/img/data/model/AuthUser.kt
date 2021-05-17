package br.com.isaias.img.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AuthUser(val email : String, val password : String) : Parcelable
