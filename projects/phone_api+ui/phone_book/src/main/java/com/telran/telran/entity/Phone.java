package com.telran.telran.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    private int code;
    @Setter
    private int number;
    @Setter
    private String type;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Contact contact;

    public Phone(int code,
                 int number,
                 String type,
                 Contact contact
    ) {
        this.code = code;
        this.number = number;
        this.type = type;
        this.contact = contact;
    }
}
