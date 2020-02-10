package pe.kreatec.basetemplate.remote

import pe.kreatec.basetemplate.remote.response.UsersResultResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("api/")
    suspend fun getUsers(@Query("results") results: Int = 50): Response<UsersResultResponse>

}