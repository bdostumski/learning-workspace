public class QueueImpl<T> implements Queue<T>  {

    private Node head;
    private Node tail;
    private int size = 0;


    @Override
    public void offer(T elem) {
        tail = new Node(elem, null);

        if(head == null) {
            head = tail;
        }

        size++;
    }

    @Override
    public T poll() {
        if(isEmpty()) {
            throw new IllegalArgumentException();
        }

        T value = (T) head.data;
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
        if(isEmpty()) {
            throw new IllegalArgumentException();
        }
        return (T) head.data;
    }

    @Override
    public int size() {
        return size;
    }
}
