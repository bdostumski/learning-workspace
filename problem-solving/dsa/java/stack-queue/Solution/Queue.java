package Solution;

public interface Queue<T> {
    
    void offer(T elem);
    
    T poll();
    
    boolean isEmpty();
    
    T peek();
    
    int size();
    
}
