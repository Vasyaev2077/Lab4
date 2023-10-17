package ru.vasyaev.MyThirdAppSpringApplication.service;

import java.util.Objects;
import org.springframework.stereotype.Service;
import ru.vasyaev.MyThirdAppSpringApplication.exception.UnsupertCodeException;
import ru.vasyaev.MyThirdAppSpringApplication.model.Request;

@Service

public class RequestUnsatedException

implements UnsupportedCodeService{
    @Override
    public void isCode(Request request) throws UnsupertCodeException {
        if (Objects.equals(request.getUid(),"123")){
            throw new UnsupertCodeException("значение UID не должно быть = 123");
        }
    }
    
}
