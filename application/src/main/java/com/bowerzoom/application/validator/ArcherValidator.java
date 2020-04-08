package com.bowerzoom.application.validator;

import com.bowerzoom.application.dto.command.ArcherFilterCmd;
import com.bowerzoom.application.dto.command.ArcherRegisterCmd;
import com.bowerzoom.application.service.archer.ArcherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class ArcherValidator {

    private final ArcherService archerService;

    public void validate(ArcherRegisterCmd archerRegisterCmd) {
        isUnique(archerRegisterCmd.getEmail());
    }

    private void isUnique(String email) {
        archerService
                .find(new ArcherFilterCmd(email))
                .ifPresent(a -> {
                    throw new ResponseStatusException(HttpStatus.CONFLICT);
                });
    }


}
