package com.shopping.shoppingserver.controller.product;

import com.shopping.shoppingserver.dto.product.DepDto;
import com.shopping.shoppingserver.service.product.DepService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/dep")
public class DepartmentController implements IProductController<DepDto> {

    private final DepService service;


    @Override
    public void add(DepDto depDto) {
        service.add(depDto);
    }


    @Override
    public void removeById(int id) {
        service.remove(id);
    }


    @Override
    public List<DepDto> getAll() {
        return service.getAll();
    }

    @Override
    public DepDto getById(int id) {
        return service.getById(id);
    }
}
