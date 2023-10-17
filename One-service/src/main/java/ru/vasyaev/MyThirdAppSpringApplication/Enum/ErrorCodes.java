package ru.vasyaev.MyThirdAppSpringApplication.Enum;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorCodes {

        EMPTY(""),

        VALIDATION_EXCEPTION("VALIDATIONEXCEPTION"),

        UNKNOWMEXCEPTION("UNKNOWMEXCEPTION"),
        UNSUPPORTED_EXCEPTION("UNSUPPORTEDEXCEPTION");

        private final String name;

        ErrorCodes(String name){
            this.name = name;
        
        }

        @JsonValue
        public String getName(){
            return name;
        }
        
        @Override
        public String toString(){
            return name;
        }
    
}
