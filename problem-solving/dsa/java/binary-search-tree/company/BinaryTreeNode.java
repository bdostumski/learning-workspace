public class BinaryTreeNode<T> {
    
    private int value;
    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public void setLeftChild(BinaryTreeNode<T> leftChild) { this.leftChild = leftChild; }
    
    public void setRightChild(BinaryTreeNode<T> rightChild) { this.rightChild = rightChild; }

    public void setValue(int value) {
        this.value = value;
    }
    
    public int getValue() { return value; }
    
    public BinaryTreeNode<T> getLeftChild() { return leftChild; }
    
    public BinaryTreeNode<T> getRightChild() {
        return rightChild;
    }

}
