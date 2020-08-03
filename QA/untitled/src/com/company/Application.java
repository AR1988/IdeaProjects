package com.company;

import com.company.exception.GlassIsEmptyException;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        List<String> groupMembers = Arrays.asList("Anna Yurchenko",
                "Gulnara Bolokadze",
                "Inna D",
                "Andre Reutow");
//TODO не очень нравится имя перменной и класса
        GroupNine members = new ActiveMemebers(groupMembers);

//TODO можно добавитб больше параметров, хотя не уверен нужни ли текущии
        Bier bier = new Bier("Bier brand", 0.5);

        filGlass(bier, members);
    }

    private static void filGlass(Bier bier, GroupNine morningGroup) {
//TODO есть предложения?
        if (bier.contains()) {
//            TODO что то другое придумать
            System.out.println(morningGroup.getAll().toString());
        } else {
            throw new GlassIsEmptyException("Fill the glass!");
        }
    }
}
