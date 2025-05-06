package app.ify.moviezapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import app.ify.moviezapp.retrofit.Movie

@Dao
interface MovieDAO {

    @Insert
    suspend fun insert(movie: Movie)

    @Insert
    suspend fun insertMoviesList(movies: List<Movie>)

    @Query("SELECT * FROM movies_table")
    suspend fun getAllMoviesInDB(): List<Movie>

    //Other queries like create delete are done here
}