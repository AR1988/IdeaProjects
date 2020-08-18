package com.telran.telran.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class PhoneDto {
    public int id;
    public int code;
    public int number;
    public String type;
    public int contactId;
}
