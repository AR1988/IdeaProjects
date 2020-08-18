package com.telran.telran.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    private String name;
    @Setter
    private String lastName;
    @Setter
    private int age;
    @Setter
    private String type;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.REMOVE)
    List<Phone> phones = new ArrayList<>();

    public Contact(int id, String name, String lastName, int age, String type) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.type = type;
    }
}
