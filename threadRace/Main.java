package threadRace;

import java.util.ArrayList;
import java.util.Collections;

import static threadRace.EvenOddNumberSeperator.evenNumberList;
import static threadRace.EvenOddNumberSeperator.oddNumberList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(10000);

        for (int i = 1; i <= 10000; i++) {
            list.add(i);
        }

        ArrayList<Integer> list1 = new ArrayList<>(2500);
        ArrayList<Integer> list2 = new ArrayList<>(2500);
        ArrayList<Integer> list3 = new ArrayList<>(2500);
        ArrayList<Integer> list4 = new ArrayList<>(2500);

        list1.addAll(list.subList(0, 2500));
        list2.addAll(list.subList(2500, 5000));
        list3.addAll(list.subList(5000, 7500));
        list4.addAll(list.subList(7500, 10000));

        EvenOddNumberSeperator sep1 = new EvenOddNumberSeperator(list1);
        EvenOddNumberSeperator sep2 = new EvenOddNumberSeperator(list2);
        EvenOddNumberSeperator sep3 = new EvenOddNumberSeperator(list3);
        EvenOddNumberSeperator sep4 = new EvenOddNumberSeperator(list4);

        Thread thread1 = new Thread(sep1);
        Thread thread2 = new Thread(sep2);
        Thread thread3 = new Thread(sep3);
        Thread thread4 = new Thread(sep4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sortLists();
        printLists();
    }

    private static void sortLists() {
        Collections.sort(evenNumberList);
        Collections.sort(oddNumberList);
    }

    private static void printLists() {
        System.out.print("Even Numbers:");
        System.out.println(evenNumberList);
        System.out.print("Odd Numbers:");
        System.out.println(oddNumberList);
    }
}
