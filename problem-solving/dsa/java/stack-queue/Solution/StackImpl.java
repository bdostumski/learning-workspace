package Solution;

public class StackImpl<T> implements Stack<T> {

    private static class Node<T> {
        private T data;
        private T next;
        private Node (T data) {
            this.data = data;
        }
    }

    private int count = 0;
    private Node top;


    @Override
    public void push(T elem) {
        Node node = new Node(elem);

        if(node != null) {
            node.next = node;
        }

        node.next = top;
        top = node;

        count++;
    }

    @Override
    public T pop() {

        if(isEmpty()) {
            throw new IllegalArgumentException("Stack is empty!");
        }

        T data = (T) top.data;
        top = (Node) top.next;

        if(top == null) {
            top = null;
        }

        count--;
        return data;
    }

    @Override
    public T peek() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Stack is empty!");
        }
        return (T) top.data;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

}
