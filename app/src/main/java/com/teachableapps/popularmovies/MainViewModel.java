package com.teachableapps.popularmovies;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.teachableapps.popularmovies.database.FavoriteMovieEntity;
import com.teachableapps.popularmovies.database.MovieDatabase;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    // Constant for logging
    private static final String TAG = MainViewModel.class.getSimpleName();

    private LiveData<List<FavoriteMovieEntity>> movies;

    public MainViewModel(Application application) {
        super(application);
        MovieDatabase database = MovieDatabase.getInstance(this.getApplication());
//        Log.d(TAG, "Actively retrieving favorite movies from the DataBase");
        movies = database.movieDao().loadAllMovies();
    }

    public LiveData<List<FavoriteMovieEntity>> getMovies() {
        return movies;
    }
}
