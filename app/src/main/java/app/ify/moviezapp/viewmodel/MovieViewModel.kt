package app.ify.moviezapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import app.ify.moviezapp.repository.Repository
import app.ify.moviezapp.retrofit.Movie

// ViewModel: Stores & Manages UI-related Data
//            Surviving configuration changes like screen rotation
//            and its prevents data loss during changes

class MovieViewModel(repository: Repository): ViewModel() {

    //ViewModel uses MutableStateOf<> instead of Livedata
    // Allowing direct Compose state handling
    var movies by mutableStateOf<List<Movie>>(emptyList())
    private set

    // The Online Movies
    var moviesFromApi by mutableStateOf<List<Movie>>(emptyList())
}