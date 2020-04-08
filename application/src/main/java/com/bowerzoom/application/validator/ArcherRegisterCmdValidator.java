package com.bowerzoom.application.validator;

import com.bowerzoom.application.dto.command.ArcherRegisterCmd;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static org.springframework.validation.ValidationUtils.rejectIfEmpty;

@Service
public class ArcherRegisterCmdValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return ArcherRegisterCmd.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ArcherRegisterCmd archerRegisterCmd = (ArcherRegisterCmd) target;
        rejectIfEmpty(errors, "email", "REQUIRED");
        rejectIfEmpty(errors, "birthDate", "REQUIRED");
        rejectIfEmpty(errors, "name", "REQUIRED");
        rejectIfEmpty(errors, "gender", "REQUIRED");
    }
}
