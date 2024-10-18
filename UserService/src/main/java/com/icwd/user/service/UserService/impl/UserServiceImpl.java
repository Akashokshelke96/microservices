package com.icwd.user.service.UserService.impl;

import com.icwd.user.service.UserService.entities.Hotel;
import com.icwd.user.service.UserService.entities.Rating;
import com.icwd.user.service.UserService.entities.User;
import com.icwd.user.service.UserService.exceptions.ResourceNotFoundException;
import com.icwd.user.service.UserService.external.services.HotelService;
import com.icwd.user.service.UserService.repositories.UserRepository;
import com.icwd.user.service.UserService.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String uuid = UUID.randomUUID().toString();
        user.setUserId(uuid);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id not found on server -> " + userId));
        //fetch ratings of the above user from the rating service.
        //http://localhost:8082/ratings/user/ad0a75ff-27db-44c2-a3e3-7e07798b779a
        //using rest template

        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/user/"+user.getUserId(), Rating[].class);

        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingList =  ratings.stream().map(rating -> {

            //api call to hotel service to get the hotel
            //map the hotel to rating
            //return the rating

//            ResponseEntity<Hotel> hotels = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+ rating.getHotelId(), Hotel.class);


            Hotel hotel = hotelService.getHotel(rating.getHotelId());
//            logger.info("response status code : { } ",hotels.getStatusCode());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratings);
        return user;

    }
}
