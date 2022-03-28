package threadRace;

import java.util.ArrayList;
import java.util.List;

public class EvenOddNumberSeperator extends Thread {

    private List<Integer> numberList;
    public static final List<Integer> oddNumberList = new ArrayList<>();
    public static List<Integer> evenNumberList = new ArrayList<>();

    private static final Object LOCK = new Object();

    EvenOddNumberSeperator(List<Integer> numberList) {
        this.numberList = numberList;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Integer number : numberList)
            synchronized (LOCK) {
                int num = number;
                if (num % 2 != 0) {
                    oddNumberList.add(num);
                } else {
                    evenNumberList.add(num);
                }
            }
    }
}