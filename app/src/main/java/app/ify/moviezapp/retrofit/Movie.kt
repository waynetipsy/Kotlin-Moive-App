package app.ify.moviezapp.retrofit

// each field in the Movie class corresponds
// to a property in the JSON object representing a movie

//Getting list of Movie

data class Movie(
    val title : String,
    val overview: String,
    val poster_path: String
)
