package com.yanpramudita.websocket.service;

import com.yanpramudita.websocket.dto.MessageDto;
import com.yanpramudita.websocket.model.Message;
import com.yanpramudita.websocket.repository.MessageRepository;
import com.yanpramudita.websocket.utils.ModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class that acts as service to implement functionality related to messages
 */
@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    /**
     * Add new message
     *
     * @param messageRequest
     * @return
     */
    public MessageDto addNewMessage(MessageDto messageRequest) {
        Message messageSpec = ModelConverter.fromMessageDto(messageRequest);

        // force to a create a new one
        messageSpec.setId(null);

        Message message = messageRepository.save(messageSpec);

        return ModelConverter.toMessageDto(message);
    }
}
