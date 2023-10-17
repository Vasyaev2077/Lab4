package ru.vasyaev.MyThirdAppSpringApplication.service;

import org.springframework.stereotype.Service;
import ru.vasyaev.MyThirdAppSpringApplication.model.Response;

@Service

public interface ModifyResponseService {

    Response modify(Response response);

    
}
