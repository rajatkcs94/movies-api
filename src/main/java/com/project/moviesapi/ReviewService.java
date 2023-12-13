package com.project.moviesapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId) {

        Review review =  reviewRepository.insert(new Review(reviewBody));
        // create custom constructor with body as parameter in review class


        // define mongoTemplate class and autowire it
        // to perform various operations without using repository
        // and get job done into database

        // start a query to save into database
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewsId").value(review))
                .first();

        return review;
    }
}
