package com.shopping.shoppingserver.service.cart;

import com.shopping.shoppingserver.dto.cart.CheckOutDto;
import com.shopping.shoppingserver.mapping.cart.CheckOutMapper;
import com.shopping.shoppingserver.model.cart.CheckOut;
import com.shopping.shoppingserver.model.market.Market;
import com.shopping.shoppingserver.repo.cart.RepoCheckOut;
import com.shopping.shoppingserver.repo.market.RepoMarket;
import com.shopping.shoppingserver.service.IService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CheckOutService implements IService<CheckOutDto> {


    private final RepoCheckOut repoCheckOut;
    private final CheckOutMapper mapper;
    private final RepoMarket repoMarket;

    @Override
    public void add(CheckOutDto checkOutDto) {
        fromDto(checkOutDto);
            repoCheckOut.save(fromDto(checkOutDto));
    }

    @Override
    public List<CheckOutDto> getAll() {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public CheckOutDto getById(int id) {
        return null;
    }

    @Override
    public void edit(CheckOutDto checkOutDto) {

    }

    private CheckOutDto toDto(CheckOut checkOut) {
        return mapper.toDto(checkOut);
    }

    private CheckOut fromDto(CheckOutDto checkOutDto) {
        Market market = repoMarket.findById(checkOutDto.getMarketId());

        return mapper.fromDto(checkOutDto, market);
    }
}
