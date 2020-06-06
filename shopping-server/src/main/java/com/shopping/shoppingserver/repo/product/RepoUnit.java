package com.shopping.shoppingserver.repo.product;

import com.shopping.shoppingserver.model.product.Unit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepoUnit extends CrudRepository<Unit, Integer> {
    List<Unit> findAll();
}
