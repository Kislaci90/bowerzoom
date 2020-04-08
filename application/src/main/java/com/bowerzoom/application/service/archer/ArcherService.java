package com.bowerzoom.application.service.archer;

import com.bowerzoom.application.domain.Archer;
import com.bowerzoom.application.dto.command.ArcherFilterCmd;
import com.bowerzoom.application.dto.event.ArcherFoundEvent;
import com.bowerzoom.application.dto.command.ArcherRegisterCmd;
import com.bowerzoom.application.dto.event.ArcherRegisteredEvent;
import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ArcherService {

    private final JmsTemplate jmsTemplate;

    public Optional<Archer> register(ArcherRegisterCmd archerRegisterCmd) {
        jmsTemplate.convertAndSend(archerRegisterCmd);
        return Optional
                .ofNullable(jmsTemplate.receiveAndConvert("archer.register.result"))
                .map(ArcherRegisteredEvent.class::cast)
                .map(ArcherRegisteredEvent::getArcher);
    }

    public Optional<Archer> find(ArcherFilterCmd archerFilterCmd) {
        jmsTemplate.convertAndSend(archerFilterCmd);
        return Optional
                .ofNullable(jmsTemplate.receiveAndConvert("archer.find.result"))
                .map(ArcherFoundEvent.class::cast)
                .map(ArcherFoundEvent::getArcher);
    }

}
