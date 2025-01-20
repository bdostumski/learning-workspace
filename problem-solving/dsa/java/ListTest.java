import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListTest<T> {

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        LinkedList<Integer> ll = new LinkedList<>();
        Vector<Integer> v = new Vector<>();

        al.add(1);
        al.add(0, 2);
        System.out.println(al.contains(1));
        System.out.println(al.containsAll(al));
        al.add(3);
        al.add(4);
        System.out.println(al);
        al.listIterator();

    }

}
