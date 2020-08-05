package com.example.game3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AnswerDto {
    public String answer;
    public boolean isCorrect;
    public int questionId;
}
