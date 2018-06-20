package dherrero.moviessample.data.rest.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ThemoviedbList1 {

    @SerializedName("iso_639_1")
    @Expose
    var iso6391: String? = null
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("page")
    @Expose
    var page: Int? = null
    @SerializedName("iso_3166_1")
    @Expose
    var iso31661: String? = null
    @SerializedName("total_results")
    @Expose
    var totalResults: Int? = null
    @SerializedName("object_ids")
    @Expose
    var objectIds: ObjectIds? = null
    @SerializedName("revenue")
    @Expose
    var revenue: Double? = null
    @SerializedName("total_pages")
    @Expose
    var totalPages: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("public")
    @Expose
    var public: Boolean? = null
    @SerializedName("comments")
    @Expose
    var comments: Comments? = null
    @SerializedName("sort_by")
    @Expose
    var sortBy: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("backdrop_path")
    @Expose
    var backdropPath: String? = null
    @SerializedName("results")
    @Expose
    var results: List<Result>? = null
    @SerializedName("average_rating")
    @Expose
    var averageRating: Double? = null
    @SerializedName("runtime")
    @Expose
    var runtime: Int? = null
    @SerializedName("created_by")
    @Expose
    var createdBy: CreatedBy? = null
    @SerializedName("poster_path")
    @Expose
    var posterPath: String? = null

}
