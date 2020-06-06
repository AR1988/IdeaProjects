package com.shopping.shoppingserver.controller.market;

import com.shopping.shoppingserver.dto.market.MarketDto;
import com.shopping.shoppingserver.service.market.MarketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/market")
public class MarketController {

    private final MarketService service;
    private final String ID = "/{id}";
    private final String GET_ALL = "/get-all";

    @PostMapping("/")
    public void add(@RequestBody MarketDto marketDto) {

        service.add(marketDto);
    }

    @PutMapping("/")
    public void update(@RequestBody MarketDto marketDto) {
        service.edit(marketDto);
    }

    @DeleteMapping(ID)
    public void remove(@PathVariable int id) {
        service.remove(id);
    }

    @GetMapping(GET_ALL)
    public List<MarketDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/" + ID)
    public MarketDto getById(@PathVariable int id) {
        return service.getById(id);
    }
}
