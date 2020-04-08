package com.bowerzoom.application.dto.command;

import com.bowerzoom.application.domain.Gender;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.time.Instant;

@Value
public class ArcherRegisterCmd {
    @NotNull
    String name;
    @NotNull
    Instant birthDate;
    @NotNull
    Gender gender;
    @NotNull
    String email;
}
