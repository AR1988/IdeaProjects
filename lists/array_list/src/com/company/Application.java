package com.company;

import com.company.collection.OurArrayList;
import com.company.collection.OurLinkedList;
import com.company.comparator.CountryCodeComparator;
import com.company.object.Employee;
import com.company.object.Manager;
import com.company.object.Worker;


public class Application {

    public static void main(String[] args) {

        OurArrayList cc = makeCountryCodeList();
        cc.sort(new CountryCodeComparator());

        OurArrayList list = new OurArrayList();


    }

    static OurArrayList makeHumanList() {
        Human vasya = new Human("Vasya", 20);
        Human petya = new Human("Petya", 20);
        Human masha = new Human("Masha", 20);

        OurArrayList res = new OurArrayList();
        res.append(vasya);
        res.append(petya);
        res.append(masha);
        return res;
    }

    static OurArrayList makeWorkersList() {

        Employee id1 = new Manager("Max", "Mustermann", 1);
        Employee id2 = new Manager("Mark", "Neumann", 2);

        Employee id3 = new Worker("Elise", "Lemann", 10);
        Employee id4 = new Worker("Kai", "Mueller", 20);

        OurArrayList workersList = new OurArrayList();

        workersList.append(id1);
        workersList.append(id2);
        workersList.append(id3);
        workersList.append(id4);
        return workersList;
    }

    static OurArrayList makeCountryCodeList() {

        CountryCode russia = new CountryCode("Russia", 7);
        CountryCode germany = new CountryCode("Germany", 49);
        CountryCode usa = new CountryCode("USA", 1);
        CountryCode italy = new CountryCode("Italy", 39);
        CountryCode china = new CountryCode("China", 86);

        OurArrayList cc = new OurArrayList();

        cc.append(russia);
        cc.append(germany);
        cc.append(usa);
        cc.append(italy);
        cc.append(china);
        return cc;
    }

    static OurArrayList list() {

        OurArrayList list = new OurArrayList();

        list.append(200);
        list.append(22);
        list.append(-20);
        list.append(11);
        list.append(10);
        return list;
    }

}
