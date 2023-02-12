package com.example.demo;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
@Autowired
private MovieRepository repository;
public List<Movie> allMovies(){
	return repository.findAll();
}

public Optional<Movie> singleMovie(String imdbid) {
	return repository.findMovieByImdbId(imdbid);
}
}
