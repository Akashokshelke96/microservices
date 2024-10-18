package com.icwd.user.service.UserService.external.services;


import com.icwd.user.service.UserService.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {


    @GetMapping("/ratings/{ratingId}")
    ResponseEntity<Rating> getRating(@PathVariable String ratingId);

    @PostMapping("/ratings")
    ResponseEntity<Rating> createRating(Rating rating);

    @PutMapping("/ratings/{ratingId}")
    Rating updateRating(@PathVariable String ratingId, Rating rating);

    @DeleteMapping("/ratings/{ratingId}")
    void deleteRating(@PathVariable String ratingId);

}
