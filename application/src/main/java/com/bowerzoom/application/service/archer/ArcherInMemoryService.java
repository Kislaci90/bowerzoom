package com.bowerzoom.application.service.archer;

import com.bowerzoom.application.utils.InMemoryCondition;
import com.bowerzoom.application.converter.ArcherConverter;
import com.bowerzoom.application.domain.Archer;
import com.bowerzoom.application.dto.command.ArcherFilterCmd;
import com.bowerzoom.application.dto.command.ArcherRegisterCmd;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Conditional(InMemoryCondition.class)
public class ArcherInMemoryService extends ArcherServiceListener {

    private List<Archer> archers = new ArrayList<>();

    public Optional<Archer> registerImpl(ArcherRegisterCmd archerRegisterCmd) {
        Archer archer = ArcherConverter.from(archerRegisterCmd);
        archers.add(archer);
        return Optional.of(archer);
    }

    public Optional<Archer> findImpl(ArcherFilterCmd archerFilterCmd) {
        return archers.stream()
                .filter(archer -> archer.getEmail().equals(archerFilterCmd.email()))
                .findFirst();
    }
}
