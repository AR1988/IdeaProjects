package com.shopping.shoppingserver.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class CheckOutDto {
    int id;
    public LocalDate date;
    public int sum;
    public int marketId;
}
