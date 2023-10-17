package ru.vasyaev.service_two.service;

import ru.vasyaev.service_two.model.Response;
import ru.vasyaev.service_two.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Qualifier("ModifySystemTimeResponseService")
public class ModifySystemTimeResponseService implements ModifyResponseService{
    @Override
    public Response modify(Response response) {
        response.setSystemTime(DateTimeUtil.getCustomFormatFormat().format(new Date()));
        return response;
    }
}
