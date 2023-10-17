package ru.vasyaev.MyThirdAppSpringApplication.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.vasyaev.MyThirdAppSpringApplication.exception.ValidationFailedException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RequestValidationService implements ValidationService {
    
    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException{
        if (bindingResult.hasErrors()) {
            throw new
                    ValidationFailedException(bindingResult.getFieldError().getDefaultMessage());
        }
    }


}
