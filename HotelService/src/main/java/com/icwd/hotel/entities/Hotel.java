package com.icwd.hotel.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name="micro_hotel")
public class Hotel {


    @Id
    @Column(name = "hotelId")
    private String hotelId;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;


}
