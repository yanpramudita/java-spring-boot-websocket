package com.yanpramudita.websocket.service;

import com.yanpramudita.websocket.dto.MessageDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class MessageServiceTest {

    @Autowired
    private MessageService messageService;

    @Test
    public void addNewMessageTestPositiveCase() {
        MessageDto request = new MessageDto();
        request.setMessage("HELLO1");

        MessageDto response = messageService.addNewMessage(request);
        Assert.assertEquals(request.getMessage(), response.getMessage());
        Assert.assertEquals(new Long(1), response.getId());
        Assert.assertNotNull(response.getCreatedAt());
    }

    @Test
    public void addNewMessageTestAddMultiple() {
        MessageDto request = new MessageDto();
        request.setMessage("HELLO1");

        MessageDto response = messageService.addNewMessage(request);
        Assert.assertEquals(request.getMessage(), response.getMessage());
        Assert.assertEquals(new Long(1), response.getId());
        Assert.assertNotNull(response.getCreatedAt());


        MessageDto request2 = new MessageDto();
        request2.setMessage("HELLO2");
        request2.setId(1L);

        MessageDto response2 = messageService.addNewMessage(request2);
        Assert.assertEquals(request2.getMessage(), response2.getMessage());
        Assert.assertEquals(new Long(2), response2.getId());
        Assert.assertNotNull(response2.getCreatedAt());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void addNewMessageTestNegativeCase() {
        MessageDto request = new MessageDto();
        messageService.addNewMessage(request);
    }
}
