package com.yanpramudita.websocket.utils;

import com.yanpramudita.websocket.dto.MessageDto;
import com.yanpramudita.websocket.model.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that used to convert one model to another
 */
public class ModelConverter {

    public static Message fromMessageDto(MessageDto messageDto) {
        Message message = new Message();
        message.setId(messageDto.getId());
        message.setMessage(messageDto.getMessage());

        return message;
    }

    public static MessageDto toMessageDto(Message message) {
        MessageDto messageDto = new MessageDto();
        messageDto.setId(message.getId());
        messageDto.setMessage(message.getMessage());
        messageDto.setCreatedAt(message.getCreatedAt().toString());

        return messageDto;
    }

    public static List<MessageDto> toMessageDto(List<Message> messages) {
        List<MessageDto> messageDto = new ArrayList<>();

        if (messages != null) {
            for (Message message : messages) {
                messageDto.add(toMessageDto(message));
            }
        }

        return messageDto;
    }
}
