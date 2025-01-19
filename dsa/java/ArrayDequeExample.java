import java.util.ArrayDeque;

/*
ArrayDeque: ArrayDeque class which is implemented in the collection framework provides us with a way to apply resizable-array.
This is a special kind of array that grows and allows users to add or remove an element from both sides of the queue.
Array deques have no capacity restrictions and they grow as necessary to support usage.
Lets understand ArrayDeque with an example:
 */

public class ArrayDequeExample<I extends Number> {

    public static void main(String[] args) {

        ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
        dq.add(10);
        dq.add(20);
        dq.add(30);
        dq.add(40);
        dq.add(50);
        dq.add(50);

        System.out.println(dq);

        dq.clear();

        System.out.println(dq);

        dq.addFirst(3);
        dq.addFirst(6);
        dq.addFirst(9);
        System.out.println(dq);

        dq.clear();

        dq.addLast(3);
        dq.addLast(1);
        dq.addLast(4);
        System.out.println(dq);
    }
}
