package Solution1;

// Stack FILO -> First IN (head) Last OUT (tail)
// Queue FIFO -> First IN (head) First OUT (tail)

public class Node<T> {

    T data;

    Node<T> next;
    Node<T> prev;

    public Node(Node<T> prev, T data, Node<T> next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
