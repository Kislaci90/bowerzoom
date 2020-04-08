package com.bowerzoom.application.converter;

import com.bowerzoom.application.domain.Archer;
import com.bowerzoom.application.dto.command.ArcherRegisterCmd;

public class ArcherConverter {

    public static Archer from(ArcherRegisterCmd archerRegisterCmd) {
        return new Archer(
                archerRegisterCmd.getName(),
                archerRegisterCmd.getBirthDate(),
                archerRegisterCmd.getEmail(),
                archerRegisterCmd.getGender()
        );
    }


}
