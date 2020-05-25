package com.bowerzoom.application.service.archer;

import com.bowerzoom.application.domain.Archer;
import com.bowerzoom.application.dto.command.ArcherFilterCmd;
import com.bowerzoom.application.dto.command.ArcherRegisterCmd;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;

import java.util.Optional;

public abstract class ArcherServiceListener {

    @JmsListener(destination = "archer.database.create")
    @SendTo("archer.register.result")
    public Optional<Archer> register(ArcherRegisterCmd archerRegisterCmd) {
        return registerImpl(archerRegisterCmd);
    }

    protected abstract Optional<Archer> registerImpl(ArcherRegisterCmd archerRegisterCmd);

    @JmsListener(destination = "archer.database.find")
    @SendTo("archer.register.result")
    public Optional<Archer> find(ArcherFilterCmd archerFilterCmd) {
        return findImpl(archerFilterCmd);
    }

    protected abstract Optional<Archer> findImpl(ArcherFilterCmd archerFilterCmd);

}
