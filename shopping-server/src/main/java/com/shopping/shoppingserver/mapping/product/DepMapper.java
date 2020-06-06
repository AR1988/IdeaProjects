package com.shopping.shoppingserver.mapping.product;


import com.shopping.shoppingserver.mapping.IMapper;
import com.shopping.shoppingserver.dto.product.DepDto;
import com.shopping.shoppingserver.model.product.Dep;
import org.springframework.stereotype.Component;

@Component
public class DepMapper implements IMapper<DepDto, Dep> {

    @Override
    public Dep fromDto(DepDto depDto) {
        return new Dep(depDto.getName());
    }

    @Override
    public DepDto toDto(Dep dep) {
        return new DepDto(dep.getId(),
                dep.getName());
    }
}
