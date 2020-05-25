package com.bowerzoom.application.dto.event;

import com.bowerzoom.application.dto.NotificationSendStatus;
import lombok.Value;

@Value
public class NotificationSentEvent {
    NotificationSendStatus notificationSendStatus;
}
