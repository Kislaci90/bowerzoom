package com.bowerzoom.application.service.archer;

import com.bowerzoom.application.converter.ArcherConverter;
import com.bowerzoom.application.domain.Archer;
import com.bowerzoom.application.dto.command.ArcherFilterCmd;
import com.bowerzoom.application.dto.command.ArcherRegisterCmd;
import com.bowerzoom.application.repository.ArcherPostgresRepository;
import com.bowerzoom.application.repository.specifications.IsUnique;
import com.bowerzoom.application.utils.DatabaseCondition;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Conditional(DatabaseCondition.class)
@AllArgsConstructor
public class ArcherPostgresService extends ArcherServiceListener {

    private final ArcherPostgresRepository archerPostgresRepository;

    public Optional<Archer> registerImpl(ArcherRegisterCmd archerRegisterCmd) {
        Archer archer = ArcherConverter.from(archerRegisterCmd);
        archerPostgresRepository.save(archer);
        return Optional.of(archer);
    }

    public Optional<Archer> findImpl(ArcherFilterCmd archerFilterCmd) {
        return archerPostgresRepository.findOne(new IsUnique(archerFilterCmd.email()));
    }
}
