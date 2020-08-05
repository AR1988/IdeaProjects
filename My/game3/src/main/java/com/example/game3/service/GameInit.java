package com.example.game3.service;

import com.example.game3.Entity.Answer;
import com.example.game3.Entity.Question;
import com.example.game3.Entity.Theme;
import com.example.game3.Repo.AnswerRepo;
import com.example.game3.Repo.QuestionRepo;
import com.example.game3.Repo.ThemeRepo;
import com.example.game3.dto.AnswerDto;
import com.example.game3.dto.PassDto;
import com.example.game3.dto.QuestionDto;
import com.example.game3.dto.ThemeDto;
import com.example.game3.exseption.PassIsNotCorrect;
import com.example.game3.mapping.MappingUnits;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameInit {
    private final String CORRECT_PASS_FOR_EDIT = "hello";
    AnswerRepo answerRepo;
    QuestionRepo questionRepo;
    ThemeRepo themeRepo;
    MappingUnits units;

    public GameInit(AnswerRepo answerRepo, QuestionRepo questionRepo, ThemeRepo themeRepo, MappingUnits units) {
        this.answerRepo = answerRepo;
        this.questionRepo = questionRepo;
        this.themeRepo = themeRepo;
        this.units = units;
    }

    public int createTheme(ThemeDto themeDto) {
        Theme theme = units.themeFromDto(themeDto);
        themeRepo.save(theme);
        return theme.getId();
    }

    public int createQuestion(QuestionDto questionDto) {
        Question question = units.questionFromDto(questionDto);
        questionRepo.save(question);
        return question.getId();
    }

    public void createAnswer(List<AnswerDto> answerDtoList) {
        answerDtoList.forEach(answerDto -> answerRepo.save(units.answerFromDto(answerDto)));
    }

    public List<AnswerDto> getAllAnswers(int questionId) {
        List<Answer> answers = answerRepo.findAllByQuestionId(questionId);


        return answers.stream().map(answer -> units.answerToDto(answer)).collect(Collectors.toList());
    }

    public List<ThemeDto> getAllTheme() {
        List<Theme> themes = themeRepo.findAll();

        return themes.stream().map(theme -> units.themeToDto(theme)).collect(Collectors.toList());
    }

    public void passCheck(PassDto passDto) {
        String correctPass = CORRECT_PASS_FOR_EDIT;

        if (!passDto.pass.equals(correctPass))
            throw new PassIsNotCorrect("pass is not correct");
    }

    public ThemeDto getThemeById(int id) {
        Theme theme = themeRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("theme not found"));

        return units.themeToDto(theme);
    }

    public List<QuestionDto> getAllQuestions(int id) {
        List<Question> questions = questionRepo.findAllByThemeId(id);

        return questions.stream().map(question -> units.questionToDto(question)).collect(Collectors.toList());
    }

    public QuestionDto getQuestion(int themeId, int questinId) {
        Question question = questionRepo.findByIdAndThemeId(questinId, themeId);

        return units.questionToDto(question);
    }
}
