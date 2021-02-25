package br.com.isaias.img.value_obj

import android.util.Log

sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T?) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()

    override fun toString(): String = when (this) {
        is Success<*> -> "Success[data=$data]"
        is Error -> {
            Log.e(this::class.java.name, exception.message.toString())
            "Error[exception=$exception]"
        }
    }
}
