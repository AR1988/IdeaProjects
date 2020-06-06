package com.shopping.shoppingserver.service;

import javax.transaction.Transactional;
import java.util.List;

public interface IService<Dto> {

    void add(Dto dto);

    List<Dto> getAll();

    void remove(int id);

    Dto getById(int id);
    @Transactional
    void edit(Dto dto);

}
