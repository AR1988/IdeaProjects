package com.shopping.shoppingserver.controller.product;

import com.shopping.shoppingserver.dto.product.UnitDto;
import com.shopping.shoppingserver.service.product.UnitService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/unit")
public class UnitController implements IProductController<UnitDto> {

    private final UnitService service;

    @Override
    public void add(UnitDto unitDto) {
        service.add(unitDto);
    }

    @Override
    public void removeById(int id) {
        service.remove(id);
    }

    @Override
    public List<UnitDto> getAll() {
        return service.getAll();
    }

    @Override
    public UnitDto getById(int id) {
        //TODO getById Unit
        return null;
    }
}
