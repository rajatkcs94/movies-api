package com.project.moviesapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

// @Document used for document type data in mongo db
@Document(collection = "movies")
// @Data annotation used for all getters,setters and toString
// instead of writing separate getters,setters,toString
@Data

// used to get args constructor of all fields as parameters
@AllArgsConstructor

// used non args constructor
@NoArgsConstructor
public class Movie {
    @Id
    private ObjectId id;

    private String imdbId;

    private String title;

    private String releaseDate;

    private String trailerLink;

    private String poster;

    private List<String> genres;

    private List<String> backdrops;

    @DocumentReference
    private List<Review> reviewsId;

}
