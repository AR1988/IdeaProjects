package com.shopping.shoppingserver.repo.cart;

import com.shopping.shoppingserver.model.cart.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepoShoppingCart extends CrudRepository<ShoppingCart, Integer> {

    ShoppingCart findById(int id);

    List<ShoppingCart> findAll();
}
