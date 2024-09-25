package com.mellotechy.movies.repository;

import com.mellotechy.movies.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {
}

