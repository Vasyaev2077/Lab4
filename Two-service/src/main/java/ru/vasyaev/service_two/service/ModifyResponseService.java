package ru.vasyaev.service_two.service;

import ru.vasyaev.service_two.model.Response;
import org.springframework.stereotype.Service;

@Service
public interface ModifyResponseService {
    Response modify(Response response);
}
