// Java program to demonstrate
// why collection framwork was needed

import java.io.*;
import java.util.*;

public class CollectionFramework {

    public static void main(String[] args) {

        int arr[] = new int[] { 1, 2, 3, 4 };
        Vector<Integer> v = new Vector<>();
        Hashtable<Integer, String> h = new Hashtable<>();

        v.addElement(1);
        v.addElement(2);

        h.put(1, "Borislav");
        h.put(2, "Dostumski");
        h.put(3, "Alexandrov");

        System.out.println(Arrays.toString(arr));
        System.out.println(v);
        System.out.println(h);
    }
}
