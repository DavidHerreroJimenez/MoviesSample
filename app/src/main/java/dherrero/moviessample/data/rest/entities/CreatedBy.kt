package dherrero.moviessample.data.rest.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CreatedBy {

    @SerializedName("gravatar_hash")
    @Expose
    var gravatarHash: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("username")
    @Expose
    var username: String? = null
    @SerializedName("id")
    @Expose
    var id: String? = null

}
