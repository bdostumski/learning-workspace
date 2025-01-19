import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeueExapmle1 {

    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<String>();

        deque.add("Borislav");
        deque.addLast("Alexandrov");
        deque.addFirst("Dostumski");

        System.out.println(deque);

        deque.remove("Alexandrov");

        for(String d : deque)
            System.out.println(d);
    }

}
