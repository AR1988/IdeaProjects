package com.telran.phone_book.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int code;
    long number;
    String type;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    Contact contact;

    public PhoneNumber(int code, long number, String type) {
        this.code = code;
        this.number = number;
        this.type = type;
    }
}