package com.yanpramudita.websocket.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * A model that represents error response of the API
 */
@Data
public class ErrorResponseDto {
    private HttpStatus status;
    private String message;
}
