public class Node<T> {

    public T data;
    public Node prev;
    public Node next;

    public Node(Node prev, T data, Node next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}
