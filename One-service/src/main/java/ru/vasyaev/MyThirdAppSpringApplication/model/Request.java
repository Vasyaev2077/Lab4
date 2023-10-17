package ru.vasyaev.MyThirdAppSpringApplication.model;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Service;

import lombok.*;
import ru.vasyaev.MyThirdAppSpringApplication.Enum.Systems;
import ru.vasyaev.MyThirdAppSpringApplication.util.DateTimeUtil;
import java.util.Date;

@Service
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Request{

    @NotBlank(message = "Uid  не может быть пустым ")
    @Size(max = 3, message = "uid должен быть больше, чем 32 символа")
    private String uid;

    @NotBlank(message = "operationUid не может быть пустым")
    @Size(max = 32, message = "uid должен быть больше, чем 32 символа")
    private String operationUid;


    private Systems systemName;
    

    public void setSystemsTime(String systemTime) {
        if (systemTime.isEmpty()){
            this.systemTime = DateTimeUtil.getCustomFormat().format(new Date());
        }else {
            this.systemTime=systemTime;
        }

    }
    
    private String systemTime;
    private String source;
    @Min(value = 1, message = "communicationId не может быть меньше запроса, чем 1")
    @Max(value = 100000, message = "communicationId не может быть больше запроса, чем 100000")
    private int templateId;
    private int productCode;
    private int smsCode;
    private int communicationId;

    @Override
    public String toString() {
        return "Request{" +
                "uid='" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemTime='" + systemTime + '\'' +
                ", source='" + source + '\'' +
                ", communicationId=" + communicationId +
                ", templateId=" + templateId +
                ", productCode=" + productCode +
                ", smsCode=" + smsCode +
                '}';
    }

}
