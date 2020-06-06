package com.shopping.shoppingserver.service.product;

import com.shopping.shoppingserver.dto.product.DepDto;
import com.shopping.shoppingserver.mapping.product.DepMapper;
import com.shopping.shoppingserver.model.product.Dep;
import com.shopping.shoppingserver.repo.product.RepoDep;
import com.shopping.shoppingserver.service.IService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class DepService implements IService<DepDto> {

    private final RepoDep repoDep;
    private final DepMapper mapper;

    @Override
    public void add(DepDto depDto) {
        repoDep.save(fromDto(depDto));
    }

    @Override
    public List<DepDto> getAll() {
        return repoDep.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void remove(int id) {
        repoDep.deleteById(id);
    }

    @Override
    public DepDto getById(int id) {
        Dep dep = repoDep.findById(id).orElseThrow(() -> new EntityNotFoundException("Dep with id: " + id + " not found!"));
        return toDto(dep);
    }

    @Override
    public void edit(DepDto depDto) {
        //TODO edit?
    }

    private DepDto toDto(Dep dep) {
        return mapper.toDto(dep);
    }


    private Dep fromDto(DepDto depDto) {
        return mapper.fromDto(depDto);
    }
}
