package Solution1;

public class QueueImpl<T> implements Queue<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    @Override
    public void offer(T elem) {
        tail = new Node<>(null, elem, tail);

        if(head == null) {
            head = tail;
        }

        size++;
    }

    @Override
    public T poll() {
        if(isEmpty()) throw new IllegalArgumentException("The stack is empty!");

        T value = head.data;
        head = head.next;

        size--;
        return value;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public T peek() {
        if(isEmpty()) throw new IllegalArgumentException("The stack is empty!");
        return head.data;
    }

    @Override
    public int size() {
        return size;
    }
}
