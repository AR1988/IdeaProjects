package com.company;

public class MeetingFriends {
        //Home work 31.09
    public static void main(String[] args) {

        //region дано
        int petrOrder = 4;
        int mariaOrder = petrOrder / 2;
        int vasilijOrder = petrOrder - 1  + mariaOrder - 1 + 1;
        int totalBeer = petrOrder + mariaOrder + vasilijOrder;
        int check = totalBeer % 3;
        System.out.println(totalBeer + " " + check);
        //endregion

        //region выпили ли ребята по ровну
        if (totalBeer % 3 == 0){
                System.out.println("yes, can be divided equally");
        }
        else {
                System.out.println("no, can be divided equally");
        }
        //endregion

        //region Счастлива ли Мария
        if (mariaOrder >= 5){
                System.out.println("\nMaria is happy. Because she needed min. 5 mugs of beer to be happy!");
            System.out.println("maria " + mariaOrder);
            }
        else {
        int mariaNeedMore = 5 - mariaOrder;
                System.out.println("\nMaria need to order  " + mariaNeedMore + " beer more to be happy");
            System.out.println("maria " + mariaOrder);

        }
        //endregion

        //region Bonus
        double mariaOrderLiter = mariaOrder * 0.5;
        double petrOrderLiter = petrOrder * 0.5;
        double vasilijOrderLiter = vasilijOrder * 0.5;

        char charL = 'L';

                System.out.println("\nMaria ordered: " + mariaOrder + " mugs of beer or " + mariaOrderLiter + charL +
                                    "\nPetja ordered: " + petrOrder + " mugs of beer or " + petrOrderLiter + charL +
                                    "\nVasja ordered: " + vasilijOrder + " mugs of beer or " + vasilijOrderLiter + charL);


        double totalBeerLiter = totalBeer * 0.5;

                System.out.println("\nTotal beer ordered: " + totalBeer + " mugs of beer or "+ totalBeerLiter + charL);
        //endregion

    }
}
