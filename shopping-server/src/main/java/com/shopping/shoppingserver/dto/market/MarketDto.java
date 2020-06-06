package com.shopping.shoppingserver.dto.market;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MarketDto {
    int id;
    String name;
    String address;

    public MarketDto(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public List<ProductMarketDto> productMarketList = new ArrayList<>();
}
