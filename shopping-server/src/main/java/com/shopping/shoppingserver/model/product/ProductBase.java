package com.shopping.shoppingserver.model.product;

import com.shopping.shoppingserver.model.market.ProductMarket;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class ProductBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Setter
    String name;

//    String depName;
//    String unitName;

    @ManyToOne(cascade = CascadeType.ALL)
    Unit unit;
    @ManyToOne(cascade = CascadeType.ALL)
    Dep dep;

    @OneToMany(mappedBy = "productBase")
    List<ProductMarket> productMarket;

    public ProductBase(String name,
                       Unit unit,
                       Dep dep) {
        this.name = name;
        this.unit = unit;
        this.dep = dep;
    }


}
