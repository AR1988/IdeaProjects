package com.shopping.shoppingserver.repo.cart;

import com.shopping.shoppingserver.model.cart.CheckOut;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepoCheckOut extends CrudRepository<CheckOut, Integer> {

    List<CheckOut> findAll();
}
