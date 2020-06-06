package com.shopping.shoppingserver.dto.product;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductBaseDto {
    int id;
    String name;
    String unitName;
    String depName;

    int unitId;
    int depId;

}
