package com.bowerzoom.application.utils;

import com.bowerzoom.application.domain.Archer;
import com.bowerzoom.application.domain.Gender;
import com.bowerzoom.application.dto.command.ArcherRegisterCmd;

import java.time.Instant;

public class ArcherFactory {

    public static ArcherRegisterCmd archerRegisterCmd() {
        return new ArcherRegisterCmd("Test Archer", Instant.now(), Gender.MALE, "test@email.com");
    }

    public static Archer archer(ArcherRegisterCmd archerRegisterCmd) {
        return new Archer(archerRegisterCmd.getName(), archerRegisterCmd.getBirthDate(), archerRegisterCmd.getEmail(), archerRegisterCmd.getGender());
    }

    public static Archer archer(String name, Instant birthData, String email, Gender gender) {
        return new Archer(name, birthData, email, gender);
    }


}
