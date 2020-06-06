package com.shopping.shoppingserver.mapping.market;


import com.shopping.shoppingserver.dto.market.MarketDto;
import com.shopping.shoppingserver.dto.market.ProductMarketDto;
import com.shopping.shoppingserver.model.market.Market;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MarketMapper {
    public Market fromDto(MarketDto marketDto) {
        return new Market(marketDto.getName()
                , marketDto.getAddress());
    }

    public MarketDto toDto(Market market, List<ProductMarketDto> productMarketDtos) {
        return new MarketDto(market.getId(),
                market.getName(),
                market.getAddress(),
                productMarketDtos);
    }
}
