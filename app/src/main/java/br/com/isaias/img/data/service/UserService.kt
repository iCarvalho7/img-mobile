package br.com.isaias.img.data.service

import br.com.isaias.img.data.model.Photos
import br.com.isaias.img.data.model.User
import br.com.isaias.img.utils.baseRetrofit
import br.com.isaias.img.value_obj.Result
import retrofit2.http.*

interface UserService {

    @POST("auth")
    suspend fun login(): Result<User>

    @GET("users")
    suspend fun verifyIfUserExists(
        @Query("email") email: String,
        @Query("username") username: String
    ): Result<Boolean>

    @POST("users")
    suspend fun createUser(createdUser: User): Result<User>

    @PUT("users/{id}")
    suspend fun updateUser(@Path("id ") id: Long, updatedUser: User): Result<User>

    @PUT("users/{id}")
    suspend fun fetchUserById(@Path("id") id: Long): Result<User>

    @DELETE("users/{id}")
    suspend fun deleteUser(@Path("id") id: Long): Result<Unit>

    @GET("users/{id}/photos")
    suspend fun fetchFavoritesPhotos(
        @Path("id") id: Long,
        @Query("page") page: Int,
        @Query("search") search : String
    ): Result<Photos>

    companion object {
        fun getInstance(): UserService = baseRetrofit.create(UserService::class.java)
    }
}