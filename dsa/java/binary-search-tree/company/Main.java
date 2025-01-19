public class Main {
    
    public static void main(String[] args) {

        BinarySearchTree binarySearchTree = new BinarySearchTreeImpl();
        binarySearchTree.insert(1);
        binarySearchTree.insert(50);
        binarySearchTree.insert(30);
        binarySearchTree.insert(20);
        binarySearchTree.insert(70);
        binarySearchTree.insert(40);
        binarySearchTree.insert(60);
        binarySearchTree.insert(80);
        binarySearchTree.insert(72);
        binarySearchTree.insert(71);

        binarySearchTree.remove(1);

        System.out.println();
        for(int i=0; i<50; i++)
            System.out.printf("-");
        System.out.println();

        System.out.println("Root: " + binarySearchTree.getRoot().getValue());
        System.out.println("Height: " + binarySearchTree.height());
        System.out.println("Search: " + binarySearchTree.search(71).getValue());

        System.out.println();
        for(int i=0; i<50; i++)
            System.out.printf("-");
        System.out.println();

        System.out.println("BFS: " + binarySearchTree.bfs());
        System.out.println("Pre order: " + binarySearchTree.preOrder());
        System.out.println("In order: " + binarySearchTree.inOrder());
        System.out.println("Post order" + binarySearchTree.postOrder());


        System.out.println();
        for(int i=0; i<50; i++)
            System.out.printf("-");
        
        System.out.println();
        System.out.println("(BST) graph:");
        System.out.println();

        printNode(binarySearchTree.getRoot());

    }
}
