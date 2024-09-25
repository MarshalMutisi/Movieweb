package com.mellotechy.movies.service;

import com.mellotechy.movies.model.Movie;
import com.mellotechy.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;  // Assume you have a repository interface for Movie entity

    // Retrieve all movies
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Retrieve a movie by ID
    public Optional<Movie> getMovieById(String id) {
        return movieRepository.findById(id);
    }

    // Create a new movie
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Update an existing movie
    public Optional<Movie> updateMovie(String id, Movie movieDetails) {
        return movieRepository.findById(id).map(movie -> {
            movie.setTitle(movieDetails.getTitle());
            movie.setYear(movieDetails.getYear());
            movie.setCast(movieDetails.getCast());
            movie.setGenres(movieDetails.getGenres());
            movie.setHref(movieDetails.getHref());
            movie.setExtract(movieDetails.getExtract());
            movie.setThumbnail(movieDetails.getThumbnail());
            movie.setThumbnailWidth(movieDetails.getThumbnailWidth());
            movie.setThumbnailHeight(movieDetails.getThumbnailHeight());
            return movieRepository.save(movie);
        });
    }

    // Delete a movie
    public boolean deleteMovie(String id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
