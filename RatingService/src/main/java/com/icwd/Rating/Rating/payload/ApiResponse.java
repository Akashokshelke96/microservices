package com.icwd.Rating.Rating.payload;

import com.icwd.Rating.Rating.entitites.Rating;
import lombok.*;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ApiResponse {

    private boolean success;
    private HttpStatus status;
    private String message;
}
