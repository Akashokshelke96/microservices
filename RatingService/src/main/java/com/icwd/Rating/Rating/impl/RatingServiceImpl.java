package com.icwd.Rating.Rating.impl;

import com.icwd.Rating.Rating.entitites.Rating;
import com.icwd.Rating.Rating.exception.ResourceNotFoundException;
import com.icwd.Rating.Rating.repository.RatingRepository;
import com.icwd.Rating.Rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepository ratingRepository;


    @Override
    public List<Rating> getAllRating() {
        List<Rating> ratingList = ratingRepository.findAll();
        return ratingList;
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.getRatingByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.getRatingByHotelId(hotelId);
    }

    @Override
    public Rating getRating(String ratingId) {
        Rating rating = ratingRepository.findById(ratingId).orElseThrow(()-> new ResourceNotFoundException("Resource not found!" + ratingId));
        return rating;
    }

    @Override
    public Rating saveRating(Rating rating) {
        String uuid = UUID.randomUUID().toString();
        rating.setRatingId(uuid);
        Rating rating1 = ratingRepository.save(rating);
        return rating1;
    }
}
