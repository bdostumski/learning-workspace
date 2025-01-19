package Solution1;

public interface Queue<T> {
    
    void offer(T elem);
    
    T poll();
    
    boolean isEmpty();
    
    T peek();
    
    int size();
    
}
