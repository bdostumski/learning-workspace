import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample1 {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.add("Borislav");
        linkedList.add("Alexandrov");
        linkedList.add("Dostumski");

        System.out.println(linkedList);

        Iterator<String> iterator = linkedList.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
