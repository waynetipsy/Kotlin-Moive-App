package app.ify.moviezapp.retrofit

import androidx.room.Entity
import androidx.room.PrimaryKey

// each field in the Movie class corresponds
// to a property in the JSON object representing a movie

//Getting list of Movie

@Entity(tableName = "movies_table")
data class Movie(

    @PrimaryKey
    val id : Int,
    val title : String,
    val overview: String,
    val poster_path: String
)
