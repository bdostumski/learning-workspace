import java.util.PriorityQueue;

/*
Priority Queue: A PriorityQueue is used when the objects are supposed to be processed based on the priority.
It is known that a queue follows the First-In-First-Out algorithm,
but sometimes the elements of the queue are needed to be processed according to the priority and this class is used in these cases.
The PriorityQueue is based on the priority heap. The elements of the priority queue are ordered according to the natural ordering,
or by a Comparator provided at queue construction time, depending on which constructor is used.
Let’s understand the priority queue with an example:
 */

public class PriorityQueueExample {

    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.offer(0);
        q.add(4);

        System.out.println(q);
        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.println(q.peek());
        q.offer(5);
        System.out.println(q);
        q.offer(0);
        System.out.println(q);

    }

}
