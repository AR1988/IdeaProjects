package com.shopping.shoppingserver.service.market;

import com.shopping.shoppingserver.dto.market.ProductMarketDto;
import com.shopping.shoppingserver.mapping.market.ProductMarketMapper;
import com.shopping.shoppingserver.model.market.Market;
import com.shopping.shoppingserver.model.market.ProductMarket;
import com.shopping.shoppingserver.model.product.ProductBase;
import com.shopping.shoppingserver.repo.market.RepoMarket;
import com.shopping.shoppingserver.repo.market.RepoProductMarket;
import com.shopping.shoppingserver.repo.product.RepoProductBase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProductMarketService {

    private final RepoProductBase repoProductBase;
    private final RepoProductMarket repoProductMarket;
    private final RepoMarket repoMarket;
    private final ProductMarketMapper mapper;

    public void add(ProductMarketDto productMarketDto) {
        repoProductMarket.save(fromDto(productMarketDto));
    }

    public List<ProductMarketDto> getAll(int marketId) {
        Market market = repoMarket.findById(marketId);

        return repoProductMarket.findAllByMarket(market)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public void remove(int id) {

    }

    public ProductMarketDto getById(int id) {
        return toDto(repoProductMarket.findById(id));
    }

    public void edit(ProductMarketDto productMarketDto) {

    }

    private ProductMarket fromDto(ProductMarketDto productMarketDto) {
        int marketIndex = productMarketDto.getMarketId();
        int ppIndex = productMarketDto.getProductBaseID();

        Market market = repoMarket.findById(marketIndex);
        ProductBase productBase = repoProductBase.findById(ppIndex);


        return mapper.fromDto(productMarketDto, productBase, market);
    }

    private ProductMarketDto toDto(ProductMarket productMarket) {
        return mapper.toDto(productMarket);
    }
}
