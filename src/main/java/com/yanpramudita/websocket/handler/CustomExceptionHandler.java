package com.yanpramudita.websocket.handler;

import com.yanpramudita.websocket.dto.ErrorResponseDto;
import com.yanpramudita.websocket.exception.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResponseDto> generalError(Exception ex, WebRequest request) {
        //log the error for internal consume

        ex.printStackTrace();
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        errorResponseDto.setMessage("Internal server error has occured");

        return new ResponseEntity<>(errorResponseDto, errorResponseDto.getStatus());
    }

    @ExceptionHandler({DataNotFoundException.class})
    public ResponseEntity<ErrorResponseDto> dataNotFound(Exception ex, WebRequest request) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setStatus(HttpStatus.NOT_FOUND);
        errorResponseDto.setMessage(ex.getMessage());

        return new ResponseEntity<>(errorResponseDto, errorResponseDto.getStatus());
    }
}
