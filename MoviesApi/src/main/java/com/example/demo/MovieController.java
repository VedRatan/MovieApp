package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/movies")
@CrossOrigin(maxAge = 3600)
public class MovieController {
	
	@Autowired
	MovieService service;
	
	@GetMapping
	public ResponseEntity<List<Movie>> getAllMovies(){
		return new ResponseEntity<>(service.allMovies(), HttpStatus.OK);
	}
	
	@GetMapping("/{imdbid}")
	public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbid) {
		return new ResponseEntity<Optional<Movie>>(service.singleMovie(imdbid), HttpStatus.OK);
	}

}
