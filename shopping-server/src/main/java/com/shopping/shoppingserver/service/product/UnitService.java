package com.shopping.shoppingserver.service.product;

import com.shopping.shoppingserver.dto.product.UnitDto;
import com.shopping.shoppingserver.mapping.product.UnitMapper;
import com.shopping.shoppingserver.model.product.Unit;
import com.shopping.shoppingserver.repo.product.RepoUnit;
import com.shopping.shoppingserver.service.IService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UnitService implements IService<UnitDto> {

    private final RepoUnit repoUnit;
    private final UnitMapper mapper;

    @Override
    public void add(UnitDto unitDto) {
        repoUnit.save(fromDto(unitDto));
    }

    @Override
    public List<UnitDto> getAll() {
        return repoUnit.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void remove(int id) {
        repoUnit.deleteById(id);
    }

    @Override
    public UnitDto getById(int id) {
        return null;
    }

    @Override
    public void edit(UnitDto unitDto) {
        //TODO edit
    }

    private Unit fromDto(UnitDto unitDto) {
        return mapper.fromDto(unitDto);
    }

    private UnitDto toDto(Unit unit) {
        return mapper.toDto(unit);
    }
}
