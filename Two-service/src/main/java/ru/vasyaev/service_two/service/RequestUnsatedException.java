package ru.vasyaev.service_two.service;

import ru.vasyaev.service_two.exception.UnsupertCodeException;
import ru.vasyaev.service_two.model.Request;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
public class RequestUnsatedException implements UnsupportedCodeService {

    @Override
    public void isCode(Request request) throws UnsupertCodeException {
        if (Objects.equals(request.getUid(),"123")){
            throw new UnsupertCodeException("значение UID не должно быть = 123");
        }
    }
}
