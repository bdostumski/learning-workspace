import java.util.LinkedList;
import java.util.List;

/*
LinkedList: LinkedList class is an implementation of the LinkedList data structure which is a linear data structure
where the elements are not stored in contiguous locations and every element is a separate object with a data part and address part.
The elements are linked using pointers and addresses. Each element is known as a node.
Lets understand the LinekdList with the following example:
 */

public class LinkedListExample {

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<Integer>();

        for (int i = 5; i >= 0; i--)
            ll.add(i);

        System.out.println(ll);
        ll.remove(3);
        System.out.println(ll);
        ll.addLast(10);
        ll.add(10);

        for (int i = 0; i < ll.size(); i++)
            System.out.println(ll.get(i));


        System.out.println();
        System.out.println(ll.lastIndexOf(0));
    }

}
