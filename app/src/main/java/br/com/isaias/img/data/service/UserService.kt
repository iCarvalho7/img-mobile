package br.com.isaias.img.data.service

import br.com.isaias.img.data.model.Photo
import br.com.isaias.img.data.model.User
import br.com.isaias.img.utils.baseRetrofit
import br.com.isaias.img.value_obj.Result
import retrofit2.Response
import retrofit2.http.*

interface UserService {

    @POST("auth")
    suspend fun login(): Response<User>

    @GET("users")
    suspend fun verifyIfUserExists(
        @Query("email") email: String,
        @Query("username") username: String
    ): Response<Boolean>

    @POST("users")
    suspend fun createUser(@Body createdUser: User): Response<User>

    @PUT("users/{id}")
    suspend fun updateUser(@Path("id ") id: Long, updatedUser: User): Response<User>

    @PUT("users/{id}")
    suspend fun fetchUserById(@Path("id") id: Long): Response<User>

    @DELETE("users/{id}")
    suspend fun deleteUser(@Path("id") id: Long): Response<Unit>

    @GET("users/{id}/photos")
    suspend fun fetchFavoritesPhotos(
        @Path("id") id: Long,
        @Query("page") page: Int,
        @Query("search") search : String
    ): Response<Photo>

    companion object {
        fun getInstance(): UserService = baseRetrofit.create(UserService::class.java)
    }
}