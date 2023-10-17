package ru.vasyaev.service_two.service;

import ru.vasyaev.service_two.model.Request;
import ru.vasyaev.service_two.model.Response;
import org.springframework.stereotype.Service;

@Service
public interface FormattedService {
    void modifyTime(Request request, Response response);
}
