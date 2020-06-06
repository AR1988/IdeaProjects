package com.shopping.shoppingserver.controller.product;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/default")
interface IProductController<Dto> {
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
