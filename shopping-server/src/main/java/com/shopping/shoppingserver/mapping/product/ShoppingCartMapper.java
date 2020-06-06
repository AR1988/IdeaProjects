package com.shopping.shoppingserver.mapping.product;

import com.shopping.shoppingserver.dto.cart.ShoppingCartDto;
import com.shopping.shoppingserver.model.market.ProductMarket;
import com.shopping.shoppingserver.model.cart.ShoppingCart;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapper {


    public ShoppingCart fromDto(ShoppingCartDto shoppingCartDto, ProductMarket o) {
        return new ShoppingCart(shoppingCartDto.getAmount(),
                o);
    }

    public ShoppingCartDto toDto(ShoppingCart shoppingCart) {
        return new ShoppingCartDto(shoppingCart.getId(),
                shoppingCart.getProductMarket().getProductBase().getName(),
                shoppingCart.getAmount(),
                shoppingCart.getProductMarket().getProductBase().getUnit().getName(),
                shoppingCart.getProductMarket().getProductBase().getDep().getName(),
                shoppingCart.getProductMarket().getId());
    }
}
