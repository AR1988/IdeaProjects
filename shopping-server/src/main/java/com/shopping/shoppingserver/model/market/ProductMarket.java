package com.shopping.shoppingserver.model.market;

import com.shopping.shoppingserver.model.cart.ShoppingCart;
import com.shopping.shoppingserver.model.product.ProductBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class ProductMarket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Setter
    int sector;

    @ManyToOne
    ProductBase productBase;

    @ManyToOne()
    Market market;

    @OneToOne(mappedBy = "productMarket")
    ShoppingCart shoppingCart;

    public ProductMarket(
            ProductBase productBase,
            Market market,
            int sector) {

        this.productBase = productBase;
        this.market = market;
        this.sector = sector;
    }


}
