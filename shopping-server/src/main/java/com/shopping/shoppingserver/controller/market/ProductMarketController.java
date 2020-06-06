package com.shopping.shoppingserver.controller.market;

import com.shopping.shoppingserver.dto.market.ProductMarketDto;
import com.shopping.shoppingserver.service.market.ProductMarketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/pm")
public class ProductMarketController {

    private final ProductMarketService service;
    private final String ID = "/{id}";
    private final String GET_ALL = "/get-all";

    @PostMapping("/")
    public void add(@RequestBody  ProductMarketDto productMarketDto) {
        service.add(productMarketDto);
    }

    @DeleteMapping(ID)
    public void removeById(@PathVariable int id) {
        service.remove(id);
    }

    @GetMapping(ID + GET_ALL)
    public List<ProductMarketDto> getAll(@PathVariable int id) {
        return service.getAll(id);
    }

    @GetMapping("/" + ID)
    public ProductMarketDto getById(@PathVariable int id) {
        return service.getById(id);
    }
}
