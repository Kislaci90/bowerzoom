package com.bowerzoom.application.service.registration;

import com.bowerzoom.application.domain.Archer;
import com.bowerzoom.application.dto.NotificationTemplate;
import com.bowerzoom.application.dto.command.ArcherRegisterCmd;
import com.bowerzoom.application.service.notification.NotificationService;
import com.bowerzoom.application.service.archer.ArcherService;
import com.bowerzoom.application.validator.ArcherValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final ArcherService archerService;
    private final ArcherValidator archerValidator;
    private final NotificationService notificationService;

    public Optional<Archer> registerArcher(ArcherRegisterCmd archerRegisterCmd) {
        archerValidator.validate(archerRegisterCmd);

        Optional<Archer> archer = archerService.register(archerRegisterCmd);

        notificationService.send(NotificationTemplate.REGISTRATION_SUCCESS, archer.orElseThrow());

        return archer;
    }

}
