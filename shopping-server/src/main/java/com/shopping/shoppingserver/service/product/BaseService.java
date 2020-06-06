package com.shopping.shoppingserver.service.product;

import com.shopping.shoppingserver.dto.product.ProductBaseDto;
import com.shopping.shoppingserver.mapping.product.ProductBaseMapper;
import com.shopping.shoppingserver.model.product.Dep;
import com.shopping.shoppingserver.model.product.ProductBase;
import com.shopping.shoppingserver.model.product.Unit;
import com.shopping.shoppingserver.repo.product.RepoDep;
import com.shopping.shoppingserver.repo.product.RepoProductBase;
import com.shopping.shoppingserver.repo.product.RepoUnit;
import com.shopping.shoppingserver.service.IService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BaseService implements IService<ProductBaseDto> {

    private final RepoProductBase repoProductBase;
    private final RepoUnit repoUnit;
    private final RepoDep repoDep;

    private final ProductBaseMapper mapper;

    @Override
    public void add(ProductBaseDto productBaseDto) {
        repoProductBase.save(fromDto(productBaseDto));
    }

    @Override
    public List<ProductBaseDto> getAll() {
        return repoProductBase.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void remove(int id) {
        repoProductBase.deleteById(id);
    }

    @Override
    public ProductBaseDto getById(int id) {
        return toDto(repoProductBase.findById(id));
    }

    @Override
    public void edit(ProductBaseDto productBaseDto) {
        //TODO: edit this ProductBase
    }

    private ProductBase fromDto(ProductBaseDto productBaseDto) {
        Unit unit = repoUnit.findById(productBaseDto.getUnitId()).orElseThrow(EntityNotFoundException::new);
        Dep dep = repoDep.findById(productBaseDto.getDepId()).orElseThrow(EntityNotFoundException::new);
        return mapper.fromDto(productBaseDto, unit, dep);
    }

    private ProductBaseDto toDto(ProductBase productBase) {
        return mapper.toDto(productBase);
    }
}
