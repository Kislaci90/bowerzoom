package com.bowerzoom.application.dto.event;

import com.bowerzoom.application.domain.Archer;
import lombok.Value;

@Value
public class ArcherRegisteredEvent {
    Archer archer;
}
