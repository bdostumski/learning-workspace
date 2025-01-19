package Solution1;

public class StackImpl<T> implements Stack<T> {

    private Node<T> top;
    private int size = 0;

    @Override
    public void push(T elem) {
        top = new Node<>(top, elem, null);
        size++;
    }

    @Override
    public T pop() {
        if(isEmpty()) throw new IllegalArgumentException("The stack is empty!");

        if(top == null) {
            top = null;
        }

        size--;
        return top.data;
    }

    @Override
    public T peek() {
        if(isEmpty()) throw new IllegalArgumentException("The stack is empty!");
        return top.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
