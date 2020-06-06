package com.shopping.shoppingserver.mapping.market;

import com.shopping.shoppingserver.dto.market.ProductMarketDto;
import com.shopping.shoppingserver.model.market.Market;
import com.shopping.shoppingserver.model.market.ProductMarket;
import com.shopping.shoppingserver.model.product.ProductBase;
import org.springframework.stereotype.Component;

@Component
public class ProductMarketMapper {
    public ProductMarket fromDto(ProductMarketDto productMarketDto, ProductBase productBase, Market market) {
        return new ProductMarket(productBase, market, productMarketDto.getSector());

    }

    public ProductMarketDto toDto(ProductMarket productMarket) {
        return new ProductMarketDto(productMarket.getId(),
                productMarket.getProductBase().getName(),
                productMarket.getProductBase().getUnit().getName(),
                productMarket.getProductBase().getDep().getName(),
                productMarket.getSector(),
                productMarket.getMarket().getId(),
                productMarket.getProductBase().getId());
    }
}
