package pe.kreatec.basetemplate.remote.repository

import pe.kreatec.basetemplate.remote.Api
import pe.kreatec.basetemplate.remote.response.UserResponse
import pe.kreatec.basetemplate.remote.util.ApiResponse
import pe.kreatec.basetemplate.remote.util.safeApiCall
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository
@Inject constructor(
    private val api: Api
) {

    suspend fun getUsers(): ApiResponse<List<UserResponse>> {
        return safeApiCall(
            call = {
                val result = api.getUsers()
                if (result.isSuccessful) {
                    ApiResponse.Success(result.body()?.results)
                } else {
                    ApiResponse.Error(result.code(), result.message())
                }
            },
            errorMessage = "Network error happened !"
        )
    }

}