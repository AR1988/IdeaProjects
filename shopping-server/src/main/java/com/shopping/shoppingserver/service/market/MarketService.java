package com.shopping.shoppingserver.service.market;


import com.shopping.shoppingserver.dto.market.MarketDto;
import com.shopping.shoppingserver.dto.market.ProductMarketDto;
import com.shopping.shoppingserver.mapping.market.MarketMapper;
import com.shopping.shoppingserver.mapping.market.ProductMarketMapper;
import com.shopping.shoppingserver.model.market.Market;
import com.shopping.shoppingserver.repo.market.RepoMarket;
import com.shopping.shoppingserver.repo.market.RepoProductMarket;
import com.shopping.shoppingserver.service.IService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class MarketService implements IService<MarketDto> {

    private final RepoMarket repoMarket;
    private final RepoProductMarket repoProductMarket;

    private final MarketMapper mapper;
    private final ProductMarketMapper productMarketMapper;

    @Override
    public void add(MarketDto marketDto) {
        repoMarket.save(fromDto(marketDto));
    }

    @Override
    public List<MarketDto> getAll() {
        List<Market> markets = repoMarket.findAll();
        return repoMarket.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public MarketDto getById(int id) {
        return toDto(repoMarket.findById(id));
    }

    @Override
    public void remove(int id) {
        repoMarket.deleteById(id);
    }


    @Override
    public void edit(MarketDto marketDto) {
        Market market = repoMarket.findById(marketDto.getId());

        market.setAddress(marketDto.getAddress());
        market.setName(marketDto.getName());
    }


    private Market fromDto(MarketDto marketDto) {
        return mapper.fromDto(marketDto);
    }

    private MarketDto toDto(Market market) {
        List<ProductMarketDto> pms = repoProductMarket.findAllByMarket(market).stream().map(productMarketMapper::toDto).collect(Collectors.toList());
        return mapper.toDto(market, pms);
    }
}
