package com.project.moviesapi;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepo extends MongoRepository<Movie, ObjectId> {
    // for different criteria to search
    // we can give explicit method for searching other than built in method

     Optional<Movie> findMovieByImdbId(String imdbId);
}
