package com.example.game3.Repo;

import com.example.game3.Entity.Theme;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ThemeRepo extends CrudRepository<Theme, Integer> {
    List<Theme> findAll();
}
