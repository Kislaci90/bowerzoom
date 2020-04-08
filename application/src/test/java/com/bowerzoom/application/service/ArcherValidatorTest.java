package com.bowerzoom.application.service;

import com.bowerzoom.application.dto.command.ArcherFilterCmd;
import com.bowerzoom.application.dto.command.ArcherRegisterCmd;
import com.bowerzoom.application.service.archer.ArcherService;
import com.bowerzoom.application.validator.ArcherValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static com.bowerzoom.application.utils.ArcherFactory.*;

class ArcherValidatorTest extends BaseServiceTest {

    @Mock
    private ArcherService archerService;

    @InjectMocks
    private ArcherValidator archerValidator;

    @Test
    void validate_ArcherRegisterCmd_isNotUnique() {
        ArcherRegisterCmd archerRegisterCmd = archerRegisterCmd();

        Mockito.when(archerService.find(new ArcherFilterCmd(archerRegisterCmd.getEmail())))
                .thenReturn(Optional.of(archer(archerRegisterCmd)));

        Assertions.assertThrows(ResponseStatusException.class, () -> {archerValidator.validate(archerRegisterCmd);});
    }

    @Test
    void validate_ArcherRegisterCmd_isUnique() {
        ArcherRegisterCmd archerRegisterCmd = archerRegisterCmd();

        Mockito.when(archerService.find(new ArcherFilterCmd(archerRegisterCmd.getEmail())))
                .thenReturn(Optional.empty());

        archerValidator.validate(archerRegisterCmd);
    }
}