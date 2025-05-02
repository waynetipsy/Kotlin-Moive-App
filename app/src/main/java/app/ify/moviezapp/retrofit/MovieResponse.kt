package app.ify.moviezapp.retrofit

import com.google.gson.annotations.SerializedName


  //1st step for retrofit
data class MovieResponse(
    val pages: Int,
    val results : List<Movie>,

    @SerializedName("total_pages")
    val totalPages: Int,
    val total_results: Int
)
