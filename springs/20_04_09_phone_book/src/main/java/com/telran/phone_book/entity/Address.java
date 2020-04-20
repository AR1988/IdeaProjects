package com.telran.phone_book.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String city;
    String country;
    String address;
    String zip;
    String type;
    int contactId;

    public Address(String city, String country, String address, String zip, String type, int contactId) {
        this.city = city;
        this.country = country;
        this.address = address;
        this.zip = zip;
        this.type = type;
        this.contactId = contactId;
    }



    public Address() {
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public String getZip() {
        return zip;
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

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }
}