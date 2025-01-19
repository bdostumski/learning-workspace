public class StackImpl<T> implements Stack<T> {

    private int size = 0;
    private Node<T> top;

    @Override
    public void push(T elem) {
        top = new Node<>(elem, null);
        size++;
    }

    @Override
    public T pop() {

        if(isEmpty()) {
            throw  new IllegalArgumentException();
        }

        if(top == null) {
            top = null;
        }

        size--;
        return top.data;
    }

    @Override
    public T peek() {

        if(isEmpty()) {
            throw new IllegalArgumentException();
        }

        return top.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }
}
