package com.shopping.shoppingserver.dto.cart;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ShoppingCartDto {
    int id;
    String productName;
    int amount;
    String productUnit;
    String productDep;

    int productMarketId;
}
