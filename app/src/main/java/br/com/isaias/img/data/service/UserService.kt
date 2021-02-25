package br.com.isaias.img.data.service

import br.com.isaias.img.data.model.User
import br.com.isaias.img.utils.baseRetrofit
import br.com.isaias.img.value_obj.Result
import retrofit2.http.GET

interface UserService {

    @GET
    suspend fun login() : Result<User>

    companion object{
        fun getInstance() : UserService = baseRetrofit.create(UserService::class.java)
    }
}