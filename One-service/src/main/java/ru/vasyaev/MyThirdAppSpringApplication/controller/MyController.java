package ru.vasyaev.MyThirdAppSpringApplication.controller;

import ru.vasyaev.MyThirdAppSpringApplication.Enum.Codes;
import ru.vasyaev.MyThirdAppSpringApplication.Enum.ErrorCodes;
import ru.vasyaev.MyThirdAppSpringApplication.Enum.ErrorMessages;
import ru.vasyaev.MyThirdAppSpringApplication.exception.UnsupertCodeException;
import ru.vasyaev.MyThirdAppSpringApplication.exception.ValidationFailedException;
import ru.vasyaev.MyThirdAppSpringApplication.model.Request;
import ru.vasyaev.MyThirdAppSpringApplication.model.Response;
import ru.vasyaev.MyThirdAppSpringApplication.service.*;
import ru.vasyaev.MyThirdAppSpringApplication.util.DateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
@Slf4j
@RestController
public class MyController {
    private final ValidationService validationService;
    private final UnsupportedCodeService unsupportedCodeService;
    private final ModifyRequestService modifyRequestService;
    private final ModifyResponseService modifyResponseService;

    @Autowired
    public MyController(ValidationService validationService,
                        UnsupportedCodeService unsupportedCodeService,
                        @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService,
                        @Qualifier("SystemName") ModifyRequestService modifyRequestService) {
        this.validationService = validationService;
        this.unsupportedCodeService = unsupportedCodeService;
        this.modifyRequestService = modifyRequestService;
        this.modifyResponseService = modifyResponseService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request, BindingResult bindingResult) {
        log.info("request:{}",request);

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMassage(ErrorMessages.EMPTY)
                .build();


        try{
            validationService.isValid(bindingResult);
            unsupportedCodeService.isCode(request);
        }catch (ValidationFailedException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMassage(ErrorMessages.VALIDATION);
            log.error(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }catch (UnsupertCodeException e){
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
            response.setErrorMassage(ErrorMessages.UNSUPPRTED);
            log.error(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.I_AM_A_TEAPOT);
        }
        catch (Exception e){
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWMEXCEPTION);
            response.setErrorMassage(ErrorMessages.UNKNOWN);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        log.info("response:{}", response);

        modifyRequestService.modify(request);

        modifyResponseService.modify(response);

        return new ResponseEntity<>(modifyResponseService.modify(response), HttpStatus.OK);

    }



}