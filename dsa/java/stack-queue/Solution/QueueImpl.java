package Solution;

public class QueueImpl<T> implements Queue<T> {

    private static class Node<T> {
        private T data;
        private T next;
        private Node(T data) {
            this.data = data;
        }
    }

    private int count = 0;
    private Node head;
    private Node tail;

    @Override
    public void offer(T elem) {

        Node node = new Node(elem);

        if(tail != null) {
            tail.next = node;
        }

        tail = node;

        if(head == null) {
            head = node;
        }

        count++;
    }

    @Override
    public T poll() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Empty queue!");
        }

        T data = (T)head.data;
        head = (Node) head.next;

        count--;
        return data;
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public T peek() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Empty queue!");
        }
        return (T) head.data;
    }

    @Override
    public int size() {
        return count;
    }

}
