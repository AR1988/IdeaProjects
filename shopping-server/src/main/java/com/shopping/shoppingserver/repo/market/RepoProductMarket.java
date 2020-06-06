package com.shopping.shoppingserver.repo.market;

import com.shopping.shoppingserver.model.market.Market;
import com.shopping.shoppingserver.model.market.ProductMarket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepoProductMarket extends CrudRepository<ProductMarket, Integer> {

    ProductMarket findById(int id);

    List<ProductMarket> findAllByMarket(Market market);
}
