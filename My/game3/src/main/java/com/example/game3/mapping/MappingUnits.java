package com.example.game3.mapping;

import com.example.game3.Entity.Answer;
import com.example.game3.Entity.Question;
import com.example.game3.Entity.Theme;
import com.example.game3.Repo.QuestionRepo;
import com.example.game3.Repo.ThemeRepo;
import com.example.game3.dto.AnswerDto;
import com.example.game3.dto.QuestionDto;
import com.example.game3.dto.ThemeDto;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class MappingUnits {

    QuestionRepo questionRepo;
    ThemeRepo themeRepo;

    public MappingUnits(QuestionRepo questionRepo, ThemeRepo themeRepo) {
        this.questionRepo = questionRepo;
        this.themeRepo = themeRepo;
    }

    //TODO mb not Optional
    public Question questionFromDto(QuestionDto questionDto) {
        Theme theme = themeRepo.findById(questionDto.themeId).
                orElseThrow(() -> new EntityNotFoundException("not found"));
        return new Question(theme, questionDto.question, questionDto.hit);
    }

    public QuestionDto questionToDto(Question question) {
        return new QuestionDto(question.getId(), question.getQuestion(), question.getHit(), question.getTheme().getId());
    }

    //TODO mb not Optional
    public Answer answerFromDto(AnswerDto answerDto) {
        Question question = questionRepo.findById(answerDto.questionId).
                orElseThrow(() -> new EntityNotFoundException("not found"));
        return new Answer(question, answerDto.answer, answerDto.isCorrect);
    }

    public AnswerDto answerToDto(Answer answer) {
        return new AnswerDto(answer.getAnswer(), answer.isCorrect(), answer.getQuestion().getId());
    }

    public Theme themeFromDto(ThemeDto themeDto) {
        return new Theme(themeDto.themeName);
    }

    public ThemeDto themeToDto(Theme theme) {
        return new ThemeDto(theme.getId(), theme.getThemeName());
    }
}
