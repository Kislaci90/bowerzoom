package com.bowerzoom.application.service.archer;

import com.bowerzoom.application.domain.Archer;
import com.bowerzoom.application.dto.command.ArcherFilterCmd;
import com.bowerzoom.application.dto.command.ArcherRegisterCmd;
import com.bowerzoom.application.repository.ArcherPostgresRepository;
import com.bowerzoom.application.repository.specifications.IsUnique;
import com.bowerzoom.application.service.BaseServiceTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;

import static com.bowerzoom.application.utils.ArcherFactory.archer;
import static com.bowerzoom.application.utils.ArcherFactory.archerRegisterCmd;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class ArcherPostgresServiceTest extends BaseServiceTest {

    @Mock
    private ArcherPostgresRepository archerPostgresRepository;

    @InjectMocks
    private ArcherPostgresService archerPostgresService;

    @Test
    void register_ValidArcherRegisterCmd_Success() {
        // GIVEN
        ArcherRegisterCmd archerRegisterCmd = archerRegisterCmd();

        // WHEN
        Optional<Archer> archer = archerPostgresService.register(archerRegisterCmd);

        // THEN
        assertTrue(archer.isPresent());
        verify(archerPostgresRepository).save(archer.get());
        assertNotNull(archer.get().getId());
    }

    @Test
    void find() {
        // GIVEN
        ArcherRegisterCmd archerRegisterCmd = archerRegisterCmd();
        Archer archer = archer(archerRegisterCmd);
        IsUnique isUnique = new IsUnique(archer.getEmail());

        ArcherFilterCmd archerFilterCmd = new ArcherFilterCmd(archer.getEmail());

        Mockito.when(archerPostgresRepository.findOne(isUnique)).thenReturn(Optional.of(archer));

        // WHEN
        Optional<Archer> foundArcher = archerPostgresService.find(archerFilterCmd);

        // THEN
        verify(archerPostgresRepository).findOne(isUnique);

        assertTrue(foundArcher.isPresent());
        assertEquals(foundArcher.get(), archer);
    }
}