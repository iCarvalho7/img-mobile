package br.com.isaias.img.data.data_source

import br.com.isaias.img.data.model.AuthUser
import br.com.isaias.img.data.model.User
import br.com.isaias.img.data.model.response.UserResponse
import br.com.isaias.img.data.repository.UserRepository
import br.com.isaias.img.data.service.UserService
import br.com.isaias.img.value_obj.Result
import retrofit2.HttpException

class UserDataSource(
    private val userService: UserService
) : UserRepository {

    override suspend fun login(email: String, password : String): Result<UserResponse> = try {
        val result = userService.login(AuthUser(email, password))
        if(result.isSuccessful && result.body() != null){
            Result.Success(result.body())
        }else{
            Result.Error(HttpException(result))
        }
    }catch (e : Exception){
        Result.Error(e)
    }

    override suspend fun signUp(createdUser: User): Result<UserResponse> = try {
        val result = userService.createUser(createdUser)
        if(result.isSuccessful && result.body() != null){
            Result.Success(result.body())
        }else{
            Result.Error(HttpException(result))
        }
    }catch (e : Exception){
        Result.Error(e)
    }
}