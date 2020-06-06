package com.shopping.shoppingserver.model.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Dep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Setter
    String name;

    //    @OneToOne(mappedBy = "dep")
    @OneToMany(mappedBy = "dep")
    List<ProductBase> productBaseList;

    public Dep(String name) {
        this.name = name;
    }
}
