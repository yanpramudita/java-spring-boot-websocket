package com.yanpramudita.websocket.service;

import com.yanpramudita.websocket.dto.MessageDto;
import com.yanpramudita.websocket.exception.DataNotFoundException;
import com.yanpramudita.websocket.model.Message;
import com.yanpramudita.websocket.repository.MessageRepository;
import com.yanpramudita.websocket.utils.ModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Class that acts as service to implement functionality related to messages
 */
@Service
public class MessageService {
    @Autowired
    private MessageSendingOperations<String> messagingTemplate;

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

        MessageDto messageDto = ModelConverter.toMessageDto(message);

        // send to websocket subscribers
        messagingTemplate.convertAndSend("/topic/messages", messageDto);
        return messageDto;
    }

    /**
     * Get message by Id
     *
     * @param id
     * @return
     */
    public MessageDto getMessageById(Long id) throws DataNotFoundException {
        Optional<Message> message = messageRepository.findById(id);

        if (!message.isPresent()) {
            throw  new DataNotFoundException(String.format("Message with id %s not found", id));
        }

        return ModelConverter.toMessageDto(message.get());
    }

    public List<MessageDto> listMessages() {
        List<Message> messages =  messageRepository.findAll(Sort.by("createdAt"));

        return ModelConverter.toMessageDto(messages);
    }
}
