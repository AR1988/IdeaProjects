package com.telran.phone_book.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class PhoneNumber {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    @Getter
    private int code;

    @Setter
    @Getter
    private long number;

    @Setter
    @Getter
    private String type;

    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Contact contact;

    public PhoneNumber(int code, long number, String type, Contact contact) {
        this.code = code;
        this.number = number;
        this.type = type;
        this.contact = contact;
    }

}