package com.shopping.shoppingserver.mapping.product;

import com.shopping.shoppingserver.dto.product.ProductBaseDto;
import com.shopping.shoppingserver.model.product.Dep;
import com.shopping.shoppingserver.model.product.ProductBase;
import com.shopping.shoppingserver.model.product.Unit;
import org.springframework.stereotype.Component;

@Component
public class ProductBaseMapper {

    public ProductBase fromDto(ProductBaseDto productBaseDto, Unit unit, Dep dep) {
        return new ProductBase(productBaseDto.getName(),
                unit,
                dep);
    }

    public ProductBaseDto toDto(ProductBase productBase) {
        return new ProductBaseDto(productBase.getId(),
                productBase.getName(),
                productBase.getUnit().getName(),
                productBase.getDep().getName(),
                productBase.getUnit().getId(),
                productBase.getDep().getId());
    }
}
