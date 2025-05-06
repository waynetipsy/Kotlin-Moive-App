package app.ify.moviezapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import app.ify.moviezapp.repository.Repository

// Factory Classes used to create instances of 'MovieViewModel',
// especially when 'MovieViewModel' requires dependencies that
// need to be passed during its creation, such as a repository

@Suppress("UNCHECKED_CAST")
class MovieViewModelFactory (private val repository: Repository):
   ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
            return MovieViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}