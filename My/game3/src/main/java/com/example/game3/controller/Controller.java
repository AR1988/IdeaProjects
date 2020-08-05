package com.example.game3.controller;

import com.example.game3.dto.AnswerDto;
import com.example.game3.dto.PassDto;
import com.example.game3.dto.QuestionDto;
import com.example.game3.dto.ThemeDto;
import com.example.game3.service.GameInit;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/set/")
public class Controller {


    private final GameInit gameInit;

    public Controller(GameInit gameInit) {
        this.gameInit = gameInit;
    }

    @PostMapping("theme/")
    public int setTheme(@RequestBody ThemeDto themeDto) {

        return gameInit.createTheme(themeDto);

    }

    @PostMapping("question")
    public int setQuestion(@RequestBody QuestionDto questionDto) {
        return gameInit.createQuestion(questionDto);
    }

    @PostMapping("answer")
    public void setAnswer(@RequestBody List<AnswerDto> answerDtos) {
        gameInit.createAnswer(answerDtos);
    }

    @GetMapping("get")
    public List<AnswerDto> answerDtos(@PathParam("id") int id) {
        return gameInit.getAllAnswers(id);
    }

    @PostMapping("check-user")
    public void userPassCheck(@RequestBody PassDto passDto) {
         gameInit.passCheck(passDto);
    }

}
