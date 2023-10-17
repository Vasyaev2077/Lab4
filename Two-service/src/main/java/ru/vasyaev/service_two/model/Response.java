package ru.vasyaev.service_two.model;

import ru.vasyaev.service_two.Enum.Codes;
import ru.vasyaev.service_two.Enum.ErrorCodes;
import ru.vasyaev.service_two.Enum.ErrorMessages;
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
