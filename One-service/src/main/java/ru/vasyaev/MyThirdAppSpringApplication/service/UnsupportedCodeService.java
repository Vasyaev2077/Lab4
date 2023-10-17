package ru.vasyaev.MyThirdAppSpringApplication.service;

import org.springframework.stereotype.Service;
import ru.vasyaev.MyThirdAppSpringApplication.model.Request;
import ru.vasyaev.MyThirdAppSpringApplication.exception.UnsupertCodeException;

@Service
public interface UnsupportedCodeService {
    void isCode(Request request) throws UnsupertCodeException;
}