package ru.vasyaev.MyThirdAppSpringApplication.model;

import ru.vasyaev.MyThirdAppSpringApplication.Enum.Codes;
import ru.vasyaev.MyThirdAppSpringApplication.Enum.ErrorCodes;
import ru.vasyaev.MyThirdAppSpringApplication.Enum.ErrorMessages;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Response {

    private String uid;
    private String operationUid;
    private String systemTime;
    private Codes code;
    private ErrorCodes errorCode;
    private ErrorMessages errorMassage;
}
