package com.example.game3.controller;

import com.example.game3.dto.AnswerDto;
import com.example.game3.dto.QuestionDto;
import com.example.game3.dto.ThemeDto;
import com.example.game3.service.GameInit;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/get/")
public class GetController {
    GameInit gameInit;

    public GetController(GameInit gameInit) {
        this.gameInit = gameInit;
    }

    @GetMapping("themes")
    public List<ThemeDto> themeDtoList() {
        return gameInit.getAllTheme();
    }

    @GetMapping("{id}/questions")
    public List<QuestionDto> themeDtoList(@PathVariable int id) {
        return gameInit.getAllQuestions(id);
    }

    @GetMapping("{id}/theme")
    public ThemeDto getThemeById(@PathVariable int id) {
        return gameInit.getThemeById(id);
    }

    @GetMapping("{id}/answers")
    public List<AnswerDto> getAllAnswers(@PathVariable int id) {
        return gameInit.getAllAnswers(id);
    }

    @GetMapping("{themeId}/question")
    public QuestionDto getQuestion(@PathVariable int themeId, @RequestParam("id") int questinId) {
        return gameInit.getQuestion(themeId, questinId);
    }
}
