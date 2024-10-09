package com.icwd.hotel.payload;


import lombok.*;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ApiResponse {

    private String message;
    private HttpStatus status;
    private boolean success;
}
