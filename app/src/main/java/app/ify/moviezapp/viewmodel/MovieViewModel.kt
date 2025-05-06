package app.ify.moviezapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import app.ify.moviezapp.repository.Repository
import app.ify.moviezapp.retrofit.Movie
import kotlinx.coroutines.launch

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
     private set

    // The offline Movies
    var moviesFromRoomDB by mutableStateOf<List<Movie>>(emptyList())
    private set //only 'MovieViewModel' can change 'moviesFromRoomDB'

    // View Model Scope: Launch a coroutine in the scope of viewmodel
    // which means that coroutine will be tied to lifecycle of the viewmodel
    init {
        viewModelScope.launch {
           try {
         moviesFromApi = repository
             .getPopularMoviesFromApi(
                 "763de4564b2e9e570c3d7f64bf6150fd"
         )
               // Insert Movies into RoomDB
               repository.insertMoviesIntoDB(moviesFromApi)

               // Assigning 'movies' to MoveiesFromApi
               movies = moviesFromApi
           } catch (e:Exception){

               //Fetch the data from ROOM DB
               moviesFromRoomDB = repository.getMoviesFromDB()

               movies = moviesFromRoomDB

           }
        }
    }
}