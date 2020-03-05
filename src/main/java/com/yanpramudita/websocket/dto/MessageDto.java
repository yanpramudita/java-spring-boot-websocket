package com.yanpramudita.websocket.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * A class that used as an API model representing message
 * that is sent/received through this application
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageDto {
    private Long id;

    @NotNull
    private String message;

    private String createdAt;
}
