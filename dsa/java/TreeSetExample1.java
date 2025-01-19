import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetExample1 {

    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<String>();

        treeSet.add("Borislav");
        treeSet.add("Alexandrov");
        treeSet.add("Borislav");
        treeSet.add("Dostumski");

        System.out.println(treeSet);


        treeSet.removeIf(e -> e.equals("Alexandrov"));

        Iterator iterator = treeSet.iterator();

        while(iterator.hasNext())
            System.out.println(iterator.next());
    }

}
