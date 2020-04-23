package com.telran.person.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Number {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int id;
    @Getter
    @Setter
    private String number;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Getter
    @Setter
    private Person person;

    public Number(Person person, String number) {
        this.person = person;
        this.number = number;
    }
}
