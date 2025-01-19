package Solution;

public interface Stack<T> {
    
    void push(T elem);
    
    T pop();
    
    T peek();
    
    int size();
    
    boolean isEmpty();
    
}
