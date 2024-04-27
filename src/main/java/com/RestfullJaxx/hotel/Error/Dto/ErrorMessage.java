package com.RestfullJaxx.hotel.Error.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    private HttpStatus status;
    private String message;


}

