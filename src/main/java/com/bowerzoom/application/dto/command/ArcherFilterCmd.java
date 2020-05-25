package com.bowerzoom.application.dto.command;

import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Value
@Accessors(fluent = true)
@EqualsAndHashCode
public class ArcherFilterCmd {
    @NotNull
    String email;
}
