package com.icwd.Rating.Rating.services;

import com.icwd.Rating.Rating.entitites.Rating;

import java.util.List;

public interface RatingService {


    Rating getRating(String ratingId);

    Rating saveRating(Rating rating);

    List<Rating> getAllRating();

    List<Rating> getRatingByUserId(String userId);

    List<Rating> getRatingByHotelId(String hotelId);
}
