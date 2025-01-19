import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class DoublyLinkedListTest {
    
    private DoublyLinkedList<Integer> testList;
    
    @BeforeEach
    public void before() {
        testList = new DoublyLinkedListImpl<>();
    }
    
    @Test
    public void addFirst_Should_UpdateHead_When_EmptyList() {
        // Act
        testList.addFirst(5);
        
        // Assert
        Assertions.assertEquals(5, testList.getFirst().intValue());
    }
    
    @Test
    public void addFirst_Should_UpdateTail_When_EmptyList() {
        // Act
        testList.addFirst(5);
        
        // Assert
        Assertions.assertEquals(5, testList.getLast().intValue());
    }
    
    @Test
    public void addFirst_Should_UpdateHead_When_NotEmptyList() {
        // Arrange
        testList = new DoublyLinkedListImpl<>(Collections.singletonList(5));
        
        // Act
        testList.addFirst(10);
        
        // Assert
        Assertions.assertEquals(10, testList.getFirst().intValue());
    }
    
    @Test
    public void addFirst_Should_MaintainCorrectOrder() {
        // Arrange & Act
        List<Integer> values = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));
        
        for (int value : values) {
            testList.addFirst(value);
        }
        
        // Assert
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Assertions.assertTrue(testArrayMatchesExpected(expected));
    }
    
    @Test
    public void addFirst_Should_UpdateCount() {
        // Act
        testList.addFirst(1);
        testList.addFirst(1);
        testList.addFirst(1);
        
        // Assert
        Assertions.assertEquals(testList.size(), 3);
    }
    
    @Test
    public void addLast_Should_UpdateTail_When_EmptyList() {
        // Act
        testList.addLast(5);
        
        // Assert
        Assertions.assertEquals(5, testList.getLast().intValue());
    }
    
    @Test
    public void addLast_Should_UpdateHead_When_EmptyList() {
        // Act
        testList.addLast(5);
        
        // Assert
        Assertions.assertEquals(5, testList.getFirst().intValue());
    }
    
    @Test
    public void addLast_Should_UpdateTail_When_NotEmptyList() {
        // Arrange
        testList.addLast(5);
        
        // Act
        testList.addLast(10);
        
        // Assert
        Assertions.assertEquals(10, testList.getLast().intValue());
    }
    
    @Test
    public void addLast_Should_MaintainCorrectOrder() {
        // Arrange & Act
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        testList = new DoublyLinkedListImpl<>(expected);
        
        // Assert
        Assertions.assertTrue(testArrayMatchesExpected(expected));
    }
    
    @Test
    public void addLast_Should_UpdateCount() {
        // Arrange && Act
        testList.addLast(5);
        testList.addLast(5);
        
        // Assert
        Assertions.assertEquals(2, testList.size());
    }
    
    @Test
    public void add_Should_InsertNode_InMiddle() {
        // Arrange
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        testList = new DoublyLinkedListImpl<>(Arrays.asList(1, 2, 4, 5));
        
        // Act
        testList.add(2, 3);
        
        // Assert
        Assertions.assertTrue(testArrayMatchesExpected(expected));
    }
    
    @Test
    public void add_Should_InsertNode_InEnd() {
        // Arrange
        testList = new DoublyLinkedListImpl<>(Arrays.asList(1, 2, 3, 4));
        
        // Act
        testList.add(4, 5);
        
        // Assert
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        Assertions.assertTrue(testArrayMatchesExpected(expected));
    }
    
    @Test
    public void add_Should_InsertNode_AfterFreshInsert() {
        // Arrange
        testList = new DoublyLinkedListImpl<>(Arrays.asList(1, 4, 5));
        
        // Act
        testList.add(1, 2);
        testList.add(2, 3);
        
        // Assert
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        Assertions.assertTrue(testArrayMatchesExpected(expected));
    }
    
    @Test
    public void add_Should_UpdateCount() {
        // Arrange
        testList = new DoublyLinkedListImpl<>(Arrays.asList(1, 3, 4));
        
        // Act
        testList.add(1, 2);
        
        // Assert
        Assertions.assertEquals(4, testList.size());
    }
    
    @Test
    public void add_Should_ThrowNullException_When_InvalidIndex() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> testList.add(-2, 1));
    }
    
    @Test
    public void getFirst_Should_ReturnFirstElement_When_NotEmptyList() {
        // Arrange
        testList = new DoublyLinkedListImpl<>(Arrays.asList(1, 2, 3));
        
        // Act & Assert
        Assertions.assertEquals(1, testList.getFirst().intValue());
    }
    
    @Test
    public void getFirst_Should_ThrowException_When_EmptyList() {
        // Arrange
        testList = new DoublyLinkedListImpl<>();
        
        // Act & Assert
        Assertions.assertThrows(NoSuchElementException.class, () -> testList.getFirst());
    }
    
    @Test
    public void getLast_Should_ReturnLastElement_When_NotEmptyList() {
        // Arrange
        testList = new DoublyLinkedListImpl<>(Arrays.asList(1, 2, 3));
        
        // Act & Assert
        Assertions.assertEquals(3, testList.getLast().intValue());
    }
    
    @Test
    public void getLast_Should_ThrowException_When_EmptyList() {
        // Arrange
        testList = new DoublyLinkedListImpl<>();
        
        // Act & Assert
        Assertions.assertThrows(NoSuchElementException.class, () -> testList.getLast());
    }
    
    @Test
    public void get_Should_ReturnElement_When_ExistingIndex() {
        // Arrange
        testList = new DoublyLinkedListImpl<>(Arrays.asList(1, 2, 3));
        
        // Act & Assert
        Assertions.assertEquals(2, testList.get(1).intValue());
    }
    
    @Test
    public void get_Should_ThrowException_When_NotExistingIndex() {
        // Arrange
        testList = new DoublyLinkedListImpl<>(Arrays.asList(1, 2, 3));
        
        // Act & Assert
        Assertions.assertThrows(NoSuchElementException.class, () -> testList.get(5));
    }
    
    @Test
    public void indexOf_Should_ReturnIndex_When_ListWithOneElement() {
        // Arrange & Act
        testList = new DoublyLinkedListImpl<>(Collections.singletonList(3));
        int index = testList.indexOf(3);
        
        // Assert
        Assertions.assertEquals(0, index);
    }
    
    @Test
    public void indexOf_Should_ReturnIndex_When_ListWithManyElements() {
        // Arrange
        testList = new DoublyLinkedListImpl<>(Arrays.asList(1, 2, 3, 4));
        
        // Act
        int index = testList.indexOf(3);
        
        // Assert
        Assertions.assertEquals(2, index);
    }
    
    @Test
    public void indexOf_Should_ReturnIndex_When_FirstElement() {
        // Arrange
        testList = new DoublyLinkedListImpl<>(Arrays.asList(1, 2, 3, 4));
        
        // Act
        int index = testList.indexOf(1);
        
        // Assert
        Assertions.assertEquals(0, index);
    }
    
    @Test
    public void indexOf_Should_ReturnIndex_When_LastElement() {
        // Arrange
        testList = new DoublyLinkedListImpl<>(Arrays.asList(1, 2, 3, 4));
        
        // Act
        int index = testList.indexOf(4);
        
        // Assert
        Assertions.assertEquals(3, index);
    }
    
    @Test
    public void indexOf_Should_ReturnNotFound_When_EmptyList() {
        // Act
        int index = testList.indexOf(1);
        
        // Assert
        Assertions.assertEquals(-1, index);
    }
    
    @Test
    public void indexOf_Should_ReturnNotFound_When_ElementNotExist() {
        // Arrange
        testList = new DoublyLinkedListImpl<>(Arrays.asList(1, 2, 3));
        
        // Act
        int index = testList.indexOf(4);
        
        // Assert
        Assertions.assertEquals(-1, index);
    }
    
    @Test
    public void removeFirst_Should_ReturnCorrectValue_When_ListWithMultipleElements() {
        // Arrange
        testList = new DoublyLinkedListImpl<>(Arrays.asList(1, 2, 3));
        
        // Act
        int value = testList.removeFirst();
        
        // Assert
        Assertions.assertEquals(1, value);
    }
    
    @Test
    public void removeFirst_Should_ReturnCorrectValue_When_ListWithSingleElement() {
        // Arrange
        testList = new DoublyLinkedListImpl<>(Collections.singletonList(1));
        // Act
        int value = testList.removeFirst();
        
        // Assert
        Assertions.assertEquals(1, value);
    }
    
    
    @Test
    public void removeFirst_Should_ThrowException_When_EmptyList() {
        // Arrange, Act, Assert
        Assertions.assertThrows(NoSuchElementException.class, () -> testList.removeFirst());
    }
    
    @Test
    public void removeFirst_Should_DecreaseCount() {
        // Arrange
        testList = new DoublyLinkedListImpl<>(Arrays.asList(1, 2));
        
        // Act
        testList.removeFirst();
        
        // Assert
        Assertions.assertEquals(1, testList.size());
    }
    
    @Test
    public void removeLast_Should_ReturnCorrectValue_When_ListWithMultipleElements() {
        // Arrange
        testList = new DoublyLinkedListImpl<>(Arrays.asList(1, 2, 3));
        
        // Act
        int value = testList.removeLast();
        
        // Assert
        Assertions.assertEquals(3, value);
    }
    
    @Test
    public void removeLast_Should_ReturnCorrectValue_When_ListWithSingleElement() {
        // Arrange
        testList = new DoublyLinkedListImpl<>(Collections.singletonList(1));
        
        // Act
        int value = testList.removeLast();
        
        // Assert
        Assertions.assertEquals(1, value);
    }
    
    
    @Test
    public void removeLast_Should_ThrowException_when_EmptyList() {
        // Arrange, Act, Assert
        Assertions.assertThrows(NoSuchElementException.class, () -> testList.removeLast());
    }
    
    @Test
    public void removeLast_Should_DecreaseCount() {
        // Arrange
        testList = new DoublyLinkedListImpl<>(Arrays.asList(1, 2));
        
        // Act
        testList.removeLast();
        
        // Assert
        Assertions.assertEquals(1, testList.size());
    }
    
    @Test
    public void size_Should_ReturnZero_When_EmptyList() {
        // Arrange, Act, Assert
        Assertions.assertEquals(0, testList.size());
    }
    
    @Test
    public void size_Should_ReturnSize_When_NotEmptyList() {
        // Arrange
        testList = new DoublyLinkedListImpl<>(Arrays.asList(1, 2, 3));
        
        // Act
        int size = testList.size();
        
        // Assert
        Assertions.assertEquals(3, size);
    }
    
    private boolean testArrayMatchesExpected(List<Integer> values) {
        if (testList.size() != values.size()) {
            return false;
        }
        
        int index = 0;
        for (int element : testList) {
            if (element != values.get(index)) {
                return false;
            }
            index++;
        }
        
        return true;
    }
    
}
