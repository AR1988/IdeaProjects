package com.telran.telran.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class ContactDto {
    public int id;
    public String name;
    public String lastName;
    public int age;
    public String type;
}
