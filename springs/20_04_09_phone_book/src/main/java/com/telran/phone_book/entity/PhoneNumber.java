package com.telran.phone_book.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int code;
    long number;
    String type;
    int contactId;

    public PhoneNumber() {
    }

    public PhoneNumber(int code, long number, String type, int contactId) {
        this.code = code;
        this.number = number;
        this.type = type;
        this.contactId = contactId;
    }

    public int getId() {
        return id;
    }

    public int getCode() {
        return code;
    }

    public long getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public int getContactId() {
        return contactId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }
}