package com.bowerzoom.application.service.notification;

import com.bowerzoom.application.dto.NotificationSendStatus;
import com.bowerzoom.application.dto.NotificationTemplate;
import com.bowerzoom.application.dto.command.SendNotificationCmd;
import com.bowerzoom.application.dto.event.NotificationSentEvent;
import com.bowerzoom.application.utils.JmsEventPublisher;
import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.bowerzoom.application.dto.NotificationSendStatus.*;


@Service
@AllArgsConstructor
public class NotificationService {

    private final JmsTemplate jmsTemplate;
    private final JmsEventPublisher jmsEventPublisher;

    public <PAYLOAD> void send(NotificationTemplate notificationTemplate, PAYLOAD payload) {
        jmsTemplate.convertAndSend(new SendNotificationCmd<>(notificationTemplate, payload));
        NotificationSentEvent event = jmsEventPublisher.event("notification.send.result", NotificationSentEvent.class);

        Optional.ofNullable(event)
                .map(NotificationSentEvent::getNotificationSendStatus)
                .filter(notificationSendStatus -> notificationSendStatus.equals(SUCCESS))
                .orElseThrow();
    }
}
