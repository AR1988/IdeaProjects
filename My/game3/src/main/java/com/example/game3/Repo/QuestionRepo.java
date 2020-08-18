package com.example.game3.Repo;

import com.example.game3.Entity.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepo extends CrudRepository<Question, Integer> {

    List<Question> findAllByThemeId(int themeId);

    Question findByIdAndThemeId(int themeId, int questionId);
}
