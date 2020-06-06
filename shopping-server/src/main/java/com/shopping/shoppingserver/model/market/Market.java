package com.shopping.shoppingserver.model.market;

import com.shopping.shoppingserver.model.cart.CheckOut;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Setter
    String name;
    @Setter
    String address;

    @OneToMany(mappedBy = "market")
    Set<ProductMarket> productMarketList = new HashSet<>();

    @OneToOne(mappedBy = "market")
    CheckOut checkout;

    public Market(String name,
                  String address) {
        this.name = name;
        this.address = address;
    }
}
