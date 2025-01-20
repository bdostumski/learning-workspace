package Solution1;

public interface Stack<T> {
    
    void push(T elem);
    
    T pop();
    
    T peek();
    
    int size();
    
    boolean isEmpty();
    
}
