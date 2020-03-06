package com.yanpramudita.websocket.controller;

import com.yanpramudita.websocket.dto.MessageDto;
import com.yanpramudita.websocket.exception.DataNotFoundException;
import com.yanpramudita.websocket.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {
    private static final String PATH_PREFIX = "/api/v1";

    @Autowired
    private MessageService messageService;

    @PostMapping(PATH_PREFIX + "/message/add")
    public ResponseEntity<MessageDto> addNewMessage(@Validated @RequestBody MessageDto message) {
        return new ResponseEntity<>(messageService.addNewMessage(message), HttpStatus.OK);
    }

    @GetMapping(PATH_PREFIX + "/message/list")
    public ResponseEntity<List<MessageDto>> listMessages() {
        return new ResponseEntity<>(messageService.listMessages(), HttpStatus.OK);
    }

    @GetMapping(PATH_PREFIX + "/message/{id}")
    public ResponseEntity<MessageDto> addNewMessage(@Validated @PathVariable("id") Long id) throws DataNotFoundException {
        return new ResponseEntity<>(messageService.getMessageById(id), HttpStatus.OK);
    }
}
