package com.telran.phone_book.validation;

public class FieldViolationDto {

    public String field;

    public String message;

    public FieldViolationDto() {
    }

    public FieldViolationDto(String field, String message) {
        this.field = field;
        this.message = message;
    }
}
