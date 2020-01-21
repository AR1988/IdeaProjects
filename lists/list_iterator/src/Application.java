import collection.OurArrayList;
import collection.OurArrayListRandomIterator;
import collection.OurLinkedList;

import java.util.Collections;
import java.util.Iterator;

public class Application {
    public static void main(String... args) {
        OurArrayList<Integer> list = new OurArrayList<>();
        list.append(1);
        list.append(2);
        list.append(3);

//        Iterator<Integer> it = new OurArrayListIterator<>(list);
        Iterator<Integer> it = list.iterator();
//
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        for (int current : list) {
            System.out.print(current + " ");
        }
        System.out.println();

//linked list
        OurArrayList<Integer> linkedList = new OurArrayList<>();
        linkedList.append(6);
        linkedList.append(5);
        linkedList.append(4);
        linkedList.append(3);
        linkedList.append(2);
        linkedList.append(1);

        for (int current : linkedList) {
            System.out.print(current + " ");
        }

        Iterator<Integer> rdmIt = new OurArrayListRandomIterator(linkedList);
        System.out.println("\nRandom Iterator:");
        while (rdmIt.hasNext()) {
            System.out.print(rdmIt.next() + " ");
        }
    }
}
