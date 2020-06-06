package com.shopping.shoppingserver.repo.product;

import com.shopping.shoppingserver.model.product.Dep;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepoDep extends CrudRepository<Dep, Integer> {
    List<Dep> findAll();
}
