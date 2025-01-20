import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueueTests {
    
    private Queue<Integer> testQueue;
    
    @BeforeEach
    public void before() {
        this.testQueue = new QueueImpl<>();
    }
    
    
    @Test
    public void offer_should_addElement_whenQueueEmpty() {
        // Act
        testQueue.offer(1);
        // Assert
        Assertions.assertEquals(1, (int) testQueue.peek());
    }
    
    @Test
    public void offer_should_addElement_whenQueueNotEmpty() {
        // Arrange
        testQueue.offer(2);
        // Act
        testQueue.offer(1);
        // Assert
        Assertions.assertEquals(2, (int) testQueue.peek());
    }
    
    @Test
    public void poll_should_throwException_whenQueueEmpty() {
        // Act&Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> testQueue.poll());
    }
    
    @Test
    public void poll_should_removeProperElement_whenQueueNotEmpty() {
        // Arrange
        testQueue.offer(3);
        testQueue.offer(5);
        
        // Act
        int elem = testQueue.poll();
        
        // Assert
        Assertions.assertEquals(3, elem);
    }
    
    @Test
    public void peek_should_returnProperElement_whenOnlyOneElementInQueue() {
        // Arrange
        testQueue.offer(1);
        
        // Act && Assert
        Assertions.assertEquals(1, (int) testQueue.peek());
    }
    
    @Test
    public void peek_should_returnProperElement_whenQueueHasMultipleElements() {
        // Arrange
        testQueue.offer(4);
        testQueue.offer(5);
        testQueue.offer(6);
        
        // Act && Assert
        Assertions.assertEquals(4, (int) testQueue.peek());
    }
    
    @Test
    public void isEmpty_should_throwException_whenQueueEmpty() {
        // Act && Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> testQueue.peek());
    }
    
    @Test
    public void size_should_returnZero_whenQueueEmpty() {
        // Assert
        Assertions.assertEquals(0, testQueue.size());
    }
    
    @Test
    public void size_should_returnProperSize_whenQueueHasMultipeElements() {
        testQueue.offer(1);
        testQueue.offer(4);
        // Assert
        Assertions.assertEquals(2, testQueue.size());
    }
    
    @Test
    public void isEmpty_should_returnTrue_whenQueueIsEmpty() {
        // Assert
        Assertions.assertTrue(testQueue.isEmpty());
    }
    
    
    @Test
    public void isEmpty_should_returnFalse_whenQueueNotEmpty() {
        // Arrange
        testQueue.offer(2);
        // Assert
        Assertions.assertFalse(testQueue.isEmpty());
    }
    
    
}
