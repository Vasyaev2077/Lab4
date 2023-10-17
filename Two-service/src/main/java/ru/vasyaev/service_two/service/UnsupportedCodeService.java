package ru.vasyaev.service_two.service;

import ru.vasyaev.service_two.exception.UnsupertCodeException;
import ru.vasyaev.service_two.model.Request;
import org.springframework.stereotype.Service;

@Service
public interface UnsupportedCodeService {
    void isCode(Request request) throws UnsupertCodeException;
}
