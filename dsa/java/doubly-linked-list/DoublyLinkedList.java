public interface DoublyLinkedList<T> extends Iterable<T> {
    
    void addFirst(T value);
    
    void addLast(T value);
    
    void add(int index, T value);
    
    T getFirst();
    
    T getLast();
    
    T get(int index);
    
    int indexOf(T value);
    
    T removeFirst();
    
    T removeLast();
    
    int size();
    
}
