package com.shopping.shoppingserver.service.cart;


import com.shopping.shoppingserver.dto.cart.ShoppingCartDto;
import com.shopping.shoppingserver.mapping.product.ShoppingCartMapper;
import com.shopping.shoppingserver.model.cart.ShoppingCart;
import com.shopping.shoppingserver.model.market.ProductMarket;
import com.shopping.shoppingserver.repo.cart.RepoShoppingCart;
import com.shopping.shoppingserver.repo.market.RepoProductMarket;
import com.shopping.shoppingserver.service.IService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ShoppingCartService implements IService<ShoppingCartDto> {

    private final RepoShoppingCart repoShoppingCart;
    private final ShoppingCartMapper mapper;
    private final RepoProductMarket repoProductMarket;

    @Override
    public void add(ShoppingCartDto shoppingCartDto) {
        repoShoppingCart.save(fromDto(shoppingCartDto));
    }

    @Override
    public List<ShoppingCartDto> getAll() {
        return repoShoppingCart.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void remove(int id) {
        repoShoppingCart.deleteById(id);
    }

    @Override
    public ShoppingCartDto getById(int id) {
        return toDto(repoShoppingCart.findById(id));
    }

    @Override
    public void edit(ShoppingCartDto shoppingCartDto) {

    }

//    @Override
//    public List<ShoppingCartDto> getAll(Checkout checkout) {
//        return repoShoppingCart.findAll()
//                .stream()
//                .map(this::toDto)
//                .collect(Collectors.toList());
//
//    }

    private ShoppingCartDto toDto(ShoppingCart shoppingCart) {
        return mapper.toDto(shoppingCart);
    }

    private ShoppingCart fromDto(ShoppingCartDto shoppingCartDto) {
        ProductMarket pm = repoProductMarket.findById(shoppingCartDto.getProductMarketId());

        return mapper.fromDto(shoppingCartDto, pm);
    }
}
