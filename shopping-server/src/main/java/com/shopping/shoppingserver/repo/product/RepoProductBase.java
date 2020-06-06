package com.shopping.shoppingserver.repo.product;

import com.shopping.shoppingserver.model.product.ProductBase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepoProductBase extends CrudRepository<ProductBase, Integer> {
    ProductBase findById(int id);

    List<ProductBase> findAll();
}


//select
//pm.prod_id,
//p.NAME,
//de.name,
//u.name,
//pm.market_id,
//m.name,
//m.address
//from product_market pm
//INNER JOIN product p ON pm.prod_id = p.id
//INNER JOIN  dep de ON p.dep_id = de.id
//INNER JOIN  "union" u ON pm.union_id = u.id
//INNER JOIN  market m ON pm.market_id = m.id where m.id = 1
