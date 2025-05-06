package app.ify.moviezapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import app.ify.moviezapp.retrofit.Movie

@Database(entities = [Movie::class], version = 1)
abstract class MoviesDB : RoomDatabase(){

    //DAO
    abstract val moviesDao: MovieDAO

    // Singleton Design pattern
    // Only one instance of the DB exists, avoiding
    // unnecessary multiple instances associated with
    // repeated DB creation

    // companion object: define a static singleton
    // instance of this DB class
    companion object{

        // Volatile: prevents any possible race
        // conditions in Multithreading
        @Volatile
        private var INSTANCE: MoviesDB?= null


        fun getInstance(context : Context): MoviesDB {
            // ensuring that only one thread can execute the
            // block of code inside the synchronized block at
            // any given time
            synchronized(this) {

                var instance = INSTANCE
                if (instance == null) {

                    // Creating the DB Object
                    instance = Room.databaseBuilder(
                        context = context.applicationContext,
                        MoviesDB::class.java,
                        "movies_db"
                    ).build()

                }
                INSTANCE = instance

                return instance
            }
        }
    }
}