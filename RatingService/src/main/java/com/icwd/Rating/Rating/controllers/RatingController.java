package com.icwd.Rating.Rating.controllers;

import com.icwd.Rating.Rating.entitites.Rating;
import com.icwd.Rating.Rating.payload.ApiResponse;
import com.icwd.Rating.Rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @GetMapping("/{ratingId}")
    public ResponseEntity<Rating> getRating(@PathVariable  String ratingId){
        Rating rating = ratingService.getRating(ratingId);
        return ResponseEntity.ok(rating);
    }
    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable  String hotelId){
        List<Rating> ratingList = ratingService.getRatingByHotelId(hotelId);
        return ResponseEntity.ok(ratingList);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable  String userId){
        List<Rating> ratingList = ratingService.getRatingByUserId(userId);
        return ResponseEntity.ok(ratingList);
    }

    
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings(){
        List<Rating> ratingList = ratingService.getAllRating();

        return ResponseEntity.ok(ratingList);
    }

    @PostMapping
    public ResponseEntity<Rating> saveRating(@RequestBody Rating rating){
        ratingService.saveRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating);
    }

}
