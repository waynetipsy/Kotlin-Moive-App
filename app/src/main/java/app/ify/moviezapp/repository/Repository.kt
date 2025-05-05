package app.ify.moviezapp.repository

import app.ify.moviezapp.retrofit.Movie
import app.ify.moviezapp.retrofit.RetrofitInstance

class Repository {
   //Repository communicates with the Api and Room data

    //Fetching data from Online API
    suspend fun getPopularMoviesFromApi(apiKey:String):List<Movie>{
        return RetrofitInstance.api.getPopularMovies(apiKey).results

    }

}