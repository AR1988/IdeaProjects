package com.example.game3.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String themeName;

    @OneToMany(mappedBy = "theme")
    List<Question> questions;

    public Theme(String themeName) {
        this.themeName = themeName;
    }
}
