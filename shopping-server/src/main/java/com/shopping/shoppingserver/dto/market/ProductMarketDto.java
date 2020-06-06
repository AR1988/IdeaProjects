package com.shopping.shoppingserver.dto.market;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductMarketDto {
    int id;
    String productName;
    String productUnit;
    String productDep;

    int sector;


    int marketId;
    int productBaseID;
}
