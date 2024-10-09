package com.icwd.user.service.UserService.entities;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    private String ratingId;
    private String userId;
    private String hotelId;
    private int score;
    private String feedback;

    private Hotel hotel;

}
