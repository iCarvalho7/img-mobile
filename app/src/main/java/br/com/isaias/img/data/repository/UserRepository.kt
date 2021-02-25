package br.com.isaias.img.data.repository

import br.com.isaias.img.data.model.User
import br.com.isaias.img.value_obj.Result

interface UserRepository {
    suspend fun login() : Result<User>
}