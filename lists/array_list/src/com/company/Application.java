package com.company;

import com.company.collection.OurArrayList;
import com.company.comparator.CountryCodeComparator;
import com.company.object.Employee;
import com.company.object.Manager;
import com.company.object.Worker;


public class Application {

    public static void main(String[] args) {

        OurArrayList cc = makeCountryCodeList();
        cc.sort(new CountryCodeComparator());
    }

    static OurArrayList makeHumanList() {
        Human vasya = new Human("Vasya", 20);
        Human petya = new Human("Petya", 20);
        Human masha = new Human("Masha", 20);

        OurArrayList res = new OurArrayList();
        res.add(vasya);
        res.add(petya);
        res.add(masha);
        return res;
    }

    static OurArrayList makeWorkersList() {

        Employee id1 = new Manager("Max", "Mustermann", 1);
        Employee id2 = new Manager("Mark", "Neumann", 2);

        Employee id3 = new Worker("Elise", "Lemann", 10);
        Employee id4 = new Worker("Kai", "Mueller", 20);

        OurArrayList workersList = new OurArrayList();

        workersList.add(id1);
        workersList.add(id2);
        workersList.add(id3);
        workersList.add(id4);
        return workersList;
    }

    static OurArrayList makeCountryCodeList() {

        CountryCode russia = new CountryCode("Russia", 7);
        CountryCode germany = new CountryCode("Germany", 49);
        CountryCode usa = new CountryCode("USA", 1);
        CountryCode italy = new CountryCode("Italy", 39);
        CountryCode china = new CountryCode("China", 86);

        OurArrayList cc = new OurArrayList();

        cc.add(russia);
        cc.add(germany);
        cc.add(usa);
        cc.add(italy);
        cc.add(china);
        return cc;
    }

    static OurArrayList list() {

        OurArrayList list = new OurArrayList();

        list.add(200);
        list.add(22);
        list.add(-20);
        list.add(11);
        list.add(10);
        return list;
    }

}
