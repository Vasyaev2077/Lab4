package ru.vasyaev.MyThirdAppSpringApplication.service;

import ru.vasyaev.MyThirdAppSpringApplication.model.Request;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Qualifier("Source")
public class ModifySystemSourceRequestService implements ModifyRequestService{

    @Override
    public void modify(Request request) {

        request.setSource("Source 'service_1'");

        HttpEntity<Request> httpEntity = new HttpEntity<>(request);

        new RestTemplate().exchange("http://localhost:8084/feedback",
                HttpMethod.POST,
                httpEntity,
                new ParameterizedTypeReference<>() {
                });
    }
    
}
