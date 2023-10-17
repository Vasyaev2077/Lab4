package ru.vasyaev.MyThirdAppSpringApplication.service;

import org.springframework.stereotype.Service;
import ru.vasyaev.MyThirdAppSpringApplication.model.Request;

@Service
public interface ModifyRequestService {
    void modify(Request request);
}
