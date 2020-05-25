package com.bowerzoom.application.dto.command;

import com.bowerzoom.application.dto.NotificationTemplate;
import lombok.Value;

@Value
public class SendNotificationCmd<PAYLOAD> {
    NotificationTemplate notificationTemplate;
    PAYLOAD payload;
}
