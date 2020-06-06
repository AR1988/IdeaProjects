package com.shopping.shoppingserver.controller.market;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/market")
interface IMarketController<Dto> {
    String ID = "/{id}";
    String GET_ALL = "/get-all";

    @PostMapping("/")
    void add(@RequestBody Dto dto);

    @DeleteMapping(ID)
    void removeById(@PathVariable int id);

    @GetMapping("/" + GET_ALL)
    List<Dto> getAll();

    @GetMapping("/" + ID)
    Dto getById(@PathVariable int id);
}
