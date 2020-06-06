package com.shopping.shoppingserver.model.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Setter
    String name;

    @OneToMany(mappedBy = "unit")
    Set<ProductBase> productBaseList = new HashSet<>();

    public Unit(String name) {
        this.name = name;
    }
}
