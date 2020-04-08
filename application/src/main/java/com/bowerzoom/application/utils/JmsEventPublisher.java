package com.bowerzoom.application.utils;
import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class JmsEventPublisher {

    private final JmsTemplate jmsTemplate;

    public <EVENT> EVENT event(String destination, Class<EVENT> clazz) {
        return Optional
                .ofNullable(jmsTemplate.receiveAndConvert(destination))
                .map(clazz::cast)
                .orElseThrow();
    }
    
}
