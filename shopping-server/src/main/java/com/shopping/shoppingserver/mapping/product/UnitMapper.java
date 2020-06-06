package com.shopping.shoppingserver.mapping.product;

import com.shopping.shoppingserver.dto.product.UnitDto;
import com.shopping.shoppingserver.mapping.IMapper;
import com.shopping.shoppingserver.model.product.Unit;
import org.springframework.stereotype.Component;

@Component
public class UnitMapper implements IMapper<UnitDto, Unit> {

    @Override
    public Unit fromDto(UnitDto unitDto) {
        return new Unit(unitDto.getName());
    }

    @Override
    public UnitDto toDto(Unit unit) {
        return new UnitDto(unit.getId(),
                unit.getName());
    }
}
