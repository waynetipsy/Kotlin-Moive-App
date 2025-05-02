package app.ify.moviezapp.retrofit

import retrofit2.http.GET
import retrofit2.http.Query

 //2nd Step of retrofit
// Here you define the endpoints of your web service.
 // Each method represents an API call.

interface ApiService {
    // Define the End Points
    // Retrofit uses annotations to describe the HTTP
    // Request methods and parameters

    @GET("movie/popular")   //Using GET annotation
    suspend fun getPopularMovies(
      @Query("api_key")
      apiKey: String
    ): MovieResponse
}