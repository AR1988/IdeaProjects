package com.example.game3.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@Getter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    private String question;

    @Setter
    private String hit;

    @ManyToOne
    private Theme theme;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers = new ArrayList<>();

    public Question(Theme theme, String question, String hit) {
        this.theme = theme;
        this.question = question;
        this.hit = hit;
    }

}
