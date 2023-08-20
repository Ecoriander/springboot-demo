package com.coriander.rabbit;

import com.example.springbootdemo.SpringbootDemoApplication;
import com.coriander.rabbit.api.Message;
import com.coriander.rabbit.api.MessageType;
import com.coriander.rabbit.producer.broker.ProducerClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootDemoApplication.class)
public class ApplicationTests {

    @Autowired
    private ProducerClient producerClient;

    @Test
    public void testProducerClient() throws Exception {

        for (int i = 0; i < 1; i++) {
            String uniqueId = UUID.randomUUID().toString();
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("name", "张三");
            attributes.put("age", "18");

            Message message = new Message(
                    uniqueId,
                    "exchange-1",
                    "springboot.abc",
                    attributes,
                    0);
            message.setMessageType(MessageType.RAPID);
//			message.setDelayMills(15000);
            producerClient.send(message);
        }

        Thread.sleep(100000);
    }
    @Test
    public void testProducerClient2() throws Exception {

        for (int i = 0; i < 1; i++) {
            String uniqueId = UUID.randomUUID().toString();
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("name", "张三");
            attributes.put("age", "18");

            Message message = new Message(
                    uniqueId,
                    "exchange-2",
                    "springboot2.abc",
                    attributes,
                    0);
            message.setMessageType(MessageType.CONFIRM);
//			message.setDelayMills(15000);
            producerClient.send(message);
        }

        Thread.sleep(100000);
    }
    @Test
    public void testProducerClient3() throws Exception {

        for (int i = 0; i < 1; i++) {
            String uniqueId = UUID.randomUUID().toString();
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("name", "张三");
            attributes.put("age", "18");

            Message message = new Message(
                    uniqueId,
                    "exchange-4",
                    "springboot4.abc",
                    attributes,
                    0);
            message.setMessageType(MessageType.RELIANT);
//			message.setDelayMills(15000);
            producerClient.send(message);
        }

        Thread.sleep(100000);
    }

    @Test
    public void testProducerClient4() throws Exception {

        for (int i = 0; i < 1; i++) {
            String uniqueId = UUID.randomUUID().toString();
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("name", "张三");
            attributes.put("age", "18");
            Message message = new Message(
                    uniqueId,
                    "delay-exchange",
                    "delay.abc",
                    attributes,
                    15000);
            message.setMessageType(MessageType.RELIANT);
            producerClient.send(message);
        }

        Thread.sleep(100000);
    }


}
