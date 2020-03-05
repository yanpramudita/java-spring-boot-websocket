package com.yanpramudita.websocket.repository;

import com.yanpramudita.websocket.model.Message;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class MessageRepositoryTest {
    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void testCreatedTime() {
        Timestamp now = new Timestamp(new Date().getTime());
        Message spec = new Message();
        spec.setMessage("HELLO1");

        Message message = messageRepository.save(spec);
        Assert.assertEquals(spec.getMessage(), message.getMessage());
        Assert.assertEquals(new Long(1), message.getId());
        Assert.assertTrue(now.getTime() <= message.getCreatedAt().getTime());
    }
}
