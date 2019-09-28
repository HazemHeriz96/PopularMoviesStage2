package com.teachableapps.popularmovies.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MovieDao {
    @Query("SELECT * FROM FavMovies ORDER BY id")
    LiveData<List<FavoriteMovieEntity>> loadAllMovies();

    @Insert
    void insertMovie(FavoriteMovieEntity favMovie);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateMovie(FavoriteMovieEntity favMovie);

    @Delete
    void deleteMovie(FavoriteMovieEntity favMovie);

    @Query("SELECT * FROM FavMovies WHERE id = :id")
    FavoriteMovieEntity loadMovieById(int id);
}
