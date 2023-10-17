package ru.vasyaev.service_two.service;

import ru.vasyaev.service_two.model.Request;
import ru.vasyaev.service_two.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
public class ModifyFormattedServiceTime implements FormattedService {
    @Override
    public void modifyTime(Request request, Response response) {
        String systemTimeRequest = request.getSystemTime().substring(11,23);
        String systemTimeResponse = response.getSystemTime().substring(11,23);

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");

        try {
            Date date1 = format.parse(systemTimeRequest);
            Date date2 = format.parse(systemTimeResponse );

            long milliseconds = date2.getTime() - date1.getTime();

            log.info("raznitsa raboti servisa 1 и servisa 2 в milliseconds: " + milliseconds);
        } catch (ParseException e) {
            e.printStackTrace();
        }
      //System.out.println(systemTimeRequest);
    }
}
