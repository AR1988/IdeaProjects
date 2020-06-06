package com.shopping.shoppingserver.mapping.cart;

import com.shopping.shoppingserver.dto.cart.CheckOutDto;
import com.shopping.shoppingserver.model.cart.CheckOut;
import com.shopping.shoppingserver.model.market.Market;
import org.springframework.stereotype.Component;

@Component
public class CheckOutMapper {


    public CheckOut fromDto(CheckOutDto checkOutDto, Market market) {
        return new CheckOut(checkOutDto.getId(),
                checkOutDto.getDate(),
                checkOutDto.getSum(),
                market);
    }

    public CheckOutDto toDto(CheckOut checkout) {
        return new CheckOutDto(checkout.getId(),
                checkout.getDate(),
                checkout.getSum(),
                checkout.getMarket().getId());
    }
}
