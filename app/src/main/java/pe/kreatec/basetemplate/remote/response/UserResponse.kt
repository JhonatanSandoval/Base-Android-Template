package pe.kreatec.basetemplate.remote.response

import com.google.gson.annotations.SerializedName

data class UsersResultResponse(
    @SerializedName("results") val results: List<UserResponse> = listOf()
)

data class UserResponse(
    @SerializedName("login") val login: UserLoginResponse? = null,
    @SerializedName("name") val name: UserMainInfoResponse? = null,
    @SerializedName("gender") val gender: String,
    @SerializedName("email") val email: String,
    @SerializedName("picture") val picture: UserPictureInfoResponse? = null,
    @SerializedName("cell") val cell: String?
)

data class UserLoginResponse(
    @SerializedName("uuid") val uuid: String
)

data class UserPictureInfoResponse(
    @SerializedName("large") val large: String,
    @SerializedName("medium") val medium: String,
    @SerializedName("thumbnail") val thumbnail: String
)

data class UserMainInfoResponse(
    @SerializedName("first") val first: String,
    @SerializedName("last") val last: String
)