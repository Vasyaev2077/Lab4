package ru.vasyaev.service_two.service;

import ru.vasyaev.service_two.exception.ValidationFailedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Slf4j
@Service
public class RequestValidationService implements ValidationService{
    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException {
        if (bindingResult.hasErrors()){
            throw new ValidationFailedException(bindingResult.getFieldError().getDefaultMessage());
        }

    }
}
