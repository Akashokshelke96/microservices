package com.icwd.user.service.UserService;

import com.icwd.user.service.UserService.entities.Rating;
import com.icwd.user.service.UserService.external.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class UserServiceApplicationTests {

	@Autowired
	private RatingService ratingService;

	@Test
	void contextLoads() {
	}

	@Test
	void createRating(){
		Rating rating = Rating.builder().score(7).userId("a831af01-6126-4db1-ad9e-1fef0b5f3a9d").feedback("Service was awesome and expensive").hotelId("341b2cc6-10d5-45a4-b376-e898b955fda5").build();
		ResponseEntity<Rating> savedRating = ratingService.createRating(rating);
		HttpStatusCode responseCode = savedRating.getStatusCode();
		System.out.println("rating created " + savedRating);

	}

}
