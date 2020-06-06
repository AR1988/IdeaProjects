package com.shopping.shoppingserver.repo.market;

import com.shopping.shoppingserver.model.market.Market;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepoMarket extends CrudRepository<Market, Integer> {

    Market findById(int id);

    List<Market> findAll();
}
