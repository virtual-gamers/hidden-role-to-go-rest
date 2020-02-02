package com.github.virtualgamers.hrtg.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import com.github.virtualgamers.hrtg.core.publisher.Publisher;

@Component
@Primary
public class PublisherImpl implements Publisher {
    Logger logger = LoggerFactory.getLogger(PublisherImpl.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void publish(final String channel, final Object message) {
        logger.info("Publishing on Topic=" + Configuration.topicExchangeName + ", channel="
                + channel + ", with message=" + message);
        rabbitTemplate.convertAndSend(Configuration.topicExchangeName, channel, message);
    }
}
