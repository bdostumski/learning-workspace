import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackTests {
    
    private Stack<Integer> testStack;
    
    @BeforeEach
    public void before() {
        this.testStack = new StackImpl<>();
    }
    
    @Test
    public void push_should_pushElement_when_stackEmpty() {
        // Act
        testStack.push(1);
        // Assert
        Assertions.assertEquals(1, (int) testStack.peek());
    }
    
    @Test
    public void push_should_pushElement_when_StackNotEmpty() {
        // Arrange
        testStack.push(1);
        
        // Act
        testStack.push(3);
        
        Assertions.assertEquals(3, (int) testStack.peek());
    }
    
    @Test
    public void pop_should_throwException_whenStackEmpty() {
        // Act
        Assertions.assertThrows(IllegalArgumentException.class, () -> testStack.pop());
    }
    
    @Test
    public void pop_should_returnCorrectValue_whenStackNotEmpty() {
        // Arrange
        testStack.push(5);
        testStack.push(11);
        testStack.push(3);
        
        // Act&&Assert
        Assertions.assertEquals(3, (int) testStack.pop());
    }
    
    @Test
    public void peek_should_throwException_whenStackEmpty() {
        // Act
        Assertions.assertThrows(IllegalArgumentException.class, () -> testStack.peek());
    }
    
    @Test
    public void peek_should_returnCorrectValue_whenStackNotEmpty() {
        // Arrange
        testStack.push(5);
        testStack.push(11);
        testStack.push(3);
        
        // Act&&Assert
        Assertions.assertEquals(3, (int) testStack.peek());
    }
    
    @Test
    public void size_should_returnZero_whenStackEmpty() {
        // Act&&Assert
        
        Assertions.assertEquals(0, testStack.size());
    }
    
    @Test
    public void size_should_returnProperValue_whenStackNotEmpty() {
        // Arrange
        testStack.push(1);
        testStack.push(11);
        testStack.push(3);
        // Act&&Assert
        
        Assertions.assertEquals(3, testStack.size());
    }
    
    @Test
    public void isEmpty_should_returnTrue_whenStackEmpty() {
        // Assert
        Assertions.assertTrue(testStack.isEmpty());
    }
    
    @Test
    public void isEmpty_should_returnFalse_whenStackNotEmpty() {
        // Act
        testStack.push(5);
        
        // Assert
        Assertions.assertFalse(testStack.isEmpty());
    }
    
    
}
