package com.yanpramudita.websocket.controller;

import com.yanpramudita.websocket.dto.MessageDto;
import com.yanpramudita.websocket.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    private static final String PATH_PREFIX = "/api/v1";

    @Autowired
    private MessageService messageService;

    @PostMapping(PATH_PREFIX + "/message/add")
    public ResponseEntity<MessageDto> addNewMessage(@Validated @RequestBody MessageDto message) {
        return new ResponseEntity<MessageDto>(messageService.addNewMessage(message), HttpStatus.OK);
    }
}
