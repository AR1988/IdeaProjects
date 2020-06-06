package com.shopping.shoppingserver.controller.product;

import com.shopping.shoppingserver.dto.product.ProductBaseDto;
import com.shopping.shoppingserver.service.product.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/pb")
public class ProductBaseController implements IProductController<ProductBaseDto> {

    private final BaseService service;

    @Override
    public void add(ProductBaseDto productBaseDto) {
        service.add(productBaseDto);
    }

    @Override
    public void removeById(int id) {
        service.remove(id);
    }

    @Override
    public List<ProductBaseDto> getAll() {
        return service.getAll();
    }

    @Override
    public ProductBaseDto getById(int id) {
        return service.getById(id);
    }
}
