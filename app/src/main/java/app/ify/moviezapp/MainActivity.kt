package app.ify.moviezapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import app.ify.moviezapp.repository.Repository
import app.ify.moviezapp.screen.MovieScreen
import app.ify.moviezapp.ui.theme.MoviezAppTheme
import app.ify.moviezapp.viewmodel.MovieViewModel
import app.ify.moviezapp.viewmodel.MovieViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // repository
        val repository = Repository()

        // view model factory
        val viewModelFactory = MovieViewModelFactory(repository)

        //view model
        val movieViewModel = ViewModelProvider(
            this, viewModelFactory
        )[MovieViewModel::class.java]

        setContent {
            MoviezAppTheme {
                MovieScreen(viewModel = movieViewModel)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MoviezAppTheme {
        Greeting("Android")
    }
}