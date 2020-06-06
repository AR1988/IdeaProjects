package com.shopping.shoppingserver.model.cart;

import com.shopping.shoppingserver.model.market.ProductMarket;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Setter
    int amount;

    @OneToOne
    @Setter
    ProductMarket productMarket;

    public ShoppingCart(int amount, ProductMarket productMarket) {
        this.amount = amount;
        this.productMarket = productMarket;
    }
}
