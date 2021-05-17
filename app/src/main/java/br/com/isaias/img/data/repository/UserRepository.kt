package br.com.isaias.img.data.repository

import br.com.isaias.img.data.model.User
import br.com.isaias.img.data.model.response.UserResponse
import br.com.isaias.img.value_obj.Result

interface UserRepository {
    suspend fun login(email : String, password: String) : Result<UserResponse>
    suspend fun signUp(createdUser: User) : Result<UserResponse>
}