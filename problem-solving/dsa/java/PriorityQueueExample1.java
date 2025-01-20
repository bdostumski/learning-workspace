import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueExample1 {

    public static void main(String[] args) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<String>();

        priorityQueue.add("Borislav");
        priorityQueue.add("Alexandrov");
        priorityQueue.add("Dostumski");

        System.out.println(priorityQueue);
        System.out.println("Element: " + priorityQueue.element());
        System.out.println("Peek: " + priorityQueue.peek());

        Iterator<String> iterator = priorityQueue.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println(priorityQueue.remove("Dostumski"));
        System.out.println(priorityQueue);
        priorityQueue.poll();
        System.out.println(priorityQueue);

    }

}
