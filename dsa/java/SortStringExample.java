import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class SortStringExample {

    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();

        al.add("Borislav");
        al.add("Alexandrov");
        al.add("Dostumski");

        for(String i : al)
            System.out.println(i);

        System.out.println();

        Collections.sort(al);
        for(String i : al)
            System.out.println(i);

        System.out.println();

        Collections.sort(al, Collections.reverseOrder());
        for(String i : al)
            System.out.println(i);

        System.out.println();

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(2);
        numbers.add(1);
        numbers.add(5);

        for(Integer i : numbers)
            System.out.println(i);

        System.out.println();

        Collections.sort(numbers);
        for(Integer i : numbers)
            System.out.println(i);

        System.out.println();

        int max = Collections.max(numbers);
        int min = Collections.min(numbers);

        System.out.println(max + " " + min);

    }

}
