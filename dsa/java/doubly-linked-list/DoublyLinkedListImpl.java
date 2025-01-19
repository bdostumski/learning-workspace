import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedListImpl<T> implements DoublyLinkedList<T> {

    DoubleNode head;
    DoubleNode tail;
    int size;

    public DoublyLinkedListImpl() {
    }

    public DoublyLinkedListImpl(Iterable<T> iterable) {
        // Implement constructor
        iterable.forEach(this::addLast);
    }

    @Override
    public void addFirst(T value) {

        DoubleNode newNode = new DoubleNode(value);

        if(isEmpty()) {
            tail = newNode;
        } else {
            head.prev = newNode;
        }

        newNode.next = head;
        head = newNode;

        size++;
    }

    @Override
    public void addLast(T value) {

        DoubleNode newNode = new DoubleNode(value);

        if(isEmpty()) {
            head  = newNode;
        } else {
            tail.next = newNode;
        }

        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    @Override
    public void add(int index, T value) {

        if (index == size) {
            addLast(value);
            return;
        }

        if (index == 0) {
            addFirst(value);
            return;
        }

        DoubleNode right = findByIndex(index);
        DoubleNode left = right.prev;

        DoubleNode newNode = new DoubleNode(left, value, right);
        left.next = newNode;
        right.prev = newNode;

        size++;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.value;
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return tail.value;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new NoSuchElementException();
        }

        DoubleNode currnet = head;

        while(index > 0) {
            currnet = currnet.next;
            index--;
        }

        return currnet.value;
    }

    @Override
    public int indexOf(T value) {
        if (isEmpty()) {
            return -1;
        }

        int index = 0;
        DoubleNode current = head;

        while (current != null) {
            if (current.value.equals(value)) {
                return index;
            }
            current = current.next;
            index++;
        }

        return -1;
    }

    @Override
    public T removeFirst() {
        if(head == null) {
            throw new NoSuchElementException("Node is empty!");
        }

        T value = head.value;
        head = head.next;

        size--;
        return value;
    }

    @Override
    public T removeLast() {
        if(isEmpty()) {
            throw new NoSuchElementException("Node is empty!");
        }

        T value = tail.value;
        tail = tail.prev;
        size--;

        return value;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            private DoubleNode current = head;

            @Override
            public boolean hasNext() {
                return current.next != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                T toReturn = current.value;
                current = current.next;

                return toReturn;
            }
        };
    }

    private DoubleNode findByIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        DoubleNode copy = head;

        while (index > 0) {
            copy = copy.next;
            index--;
        }

        return copy;
    }

    // Implement all interfaces

    private class DoubleNode {
        T value;
        DoubleNode prev;
        DoubleNode next;

        DoubleNode(T value) {
            this.value = value;
        }

        public DoubleNode(DoubleNode prev, T value, DoubleNode next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

}
