package br.com.isaias.img.data.data_source

import br.com.isaias.img.data.model.User
import br.com.isaias.img.data.repository.UserRepository
import br.com.isaias.img.data.service.UserService
import br.com.isaias.img.value_obj.Result

class UserDataSource(
    private val userService: UserService
) : UserRepository {

    override suspend fun login(): Result<User> = try {
        val result = userService.login()
        result
    }catch (e : Exception){
        Result.Error(e)
    }
}