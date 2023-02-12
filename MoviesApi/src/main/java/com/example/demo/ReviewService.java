package com.example.demo;

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
	private MongoTemplate mongoTemplate; //it is the another way of talking to the mongodb database.
	
 public Review createReview(String body, String imdbID) {
	 Review review =  reviewRepository.insert(new Review(body));
	
	 
	 mongoTemplate.update(Movie.class)
	               .matching(Criteria.where("imdbId").is(imdbID))
	               .apply(new Update().push("reviewIds").value(review))
	               .first();
	 
	 return review;
 }
}
