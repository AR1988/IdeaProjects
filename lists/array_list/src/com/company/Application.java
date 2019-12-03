package com.company;


import com.company.collection.OurArrayList;
import com.company.object.Employee;
import com.company.object.Manager;
import com.company.object.Worker;


public class Application {

    public static void main(String[] args) {
        OurArrayList list = makeWorkersList();

        System.out.println(list.get(1).toString());
        System.out.println(list.get(3).toString());


    }

    private static OurArrayList makeWorkersList() {

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


}
