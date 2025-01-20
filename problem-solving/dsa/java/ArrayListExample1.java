import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListExample1 {

    public static void main(String[] args) {
        ArrayList<String> list1 =  new ArrayList<String>();

        list1.add("Borislav");
        list1.add("Alexandrov");
        list1.add("Dostumski");

        Collections.sort(list1, Collections.reverseOrder());

        Iterator iterator = list1.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println();

        ListIterator<String> listIterator = list1.listIterator(list1.size());
        while(listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }

}
