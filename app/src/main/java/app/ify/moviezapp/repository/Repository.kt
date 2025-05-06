package app.ify.moviezapp.repository

import android.content.Context
import app.ify.moviezapp.retrofit.Movie
import app.ify.moviezapp.retrofit.RetrofitInstance
import app.ify.moviezapp.room.MovieDAO
import app.ify.moviezapp.room.MoviesDB

class Repository (context: Context){
   //Repository communicates with the Api and Room data

    //Fetching data from Online API
    suspend fun getPopularMoviesFromApi(apiKey:String):List<Movie>{
        return RetrofitInstance.api.getPopularMovies(apiKey).results

    }

    // Fetching data from Offline ROOM Database
    private val db = MoviesDB.getInstance(context)
    private val movieDao: MovieDAO = db.moviesDao


    suspend fun getMoviesFromDB(): List<Movie> {
        return movieDao.getAllMoviesInDB()
    }
    suspend fun insertMoviesIntoDB(movies: List<Movie>){
        return movieDao.insertMoviesList(movies)
    }
    // Can call cache here
}