package com.example.game3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class QuestionDto {

    int id;

    public  String question;

    public  String hit;

    public  int themeId;

}
