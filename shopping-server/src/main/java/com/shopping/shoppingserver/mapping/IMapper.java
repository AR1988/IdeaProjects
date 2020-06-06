package com.shopping.shoppingserver.mapping;

public interface IMapper<Dto, Item> {

    Item fromDto(Dto dto);

    Dto toDto(Item item);
}
