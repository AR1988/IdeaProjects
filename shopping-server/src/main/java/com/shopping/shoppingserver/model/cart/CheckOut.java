package com.shopping.shoppingserver.model.cart;

import com.shopping.shoppingserver.model.market.Market;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class CheckOut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Setter
    LocalDate date;

    @Setter
    int sum;

    @Setter
    @OneToOne()
    Market market;

    public CheckOut(LocalDate date, int sum, Market market) {
        this.date = date;
        this.sum = sum;
        this.market = market;
    }
}
