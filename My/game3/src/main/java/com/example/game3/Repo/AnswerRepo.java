package com.example.game3.Repo;

import com.example.game3.Entity.Answer;
import com.example.game3.Entity.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnswerRepo extends CrudRepository<Answer, Integer> {

    List<Answer> findAllByQuestionId(int question_id);

}
