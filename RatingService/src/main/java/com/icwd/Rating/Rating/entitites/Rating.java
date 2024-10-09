package com.icwd.Rating.Rating.entitites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="micro_table")
public class Rating {


    @Id
    @Column
    private String ratingId;

    @Column
    private int score;

    @Column
    private String userId;

    @Column
    private String feedback;

    @Column
    private String hotelId;


}
