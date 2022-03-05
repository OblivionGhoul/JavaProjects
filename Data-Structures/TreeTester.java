public class TreeTester {
    public static void main(String[] args) {
        System.out.println("Creating an integer BSTree");
        BSTree<Integer> tree = new BSTree<>();
        System.out.println("Adding elements (1-10). I made a random shape lol.");
        tree.insert(10);
        tree.insert(1);
        tree.insert(9);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(5);
        tree.insert(6);
        tree.insert(4);
        tree.insert(8);
        System.out.println("Printing the tree: ");
        tree.print();

        tree.clear();
        System.out.println("\nCleared the tree");

        System.out.println("Adding elements to make a linear tree (10-20).");
        for (int i = 10; i <= 20; i++) {
            tree.insert(i);
        }
        System.out.println("Printing the tree: ");
        tree.print();

        tree.clear();
        System.out.println("\nCleared the tree");
        System.out.println("Adding elements to make a triangle tree (20-30).");
        tree.insert(25);
        tree.insert(24);
        tree.insert(23);
        tree.insert(22);
        tree.insert(21);
        tree.insert(20);
        tree.insert(26);
        tree.insert(27);
        tree.insert(28);
        tree.insert(29);
        tree.insert(30);
        System.out.println("Printing the tree: ");
        tree.print();

        System.out.println("\nCreating a String BSTree");
        BSTree<String> stringBSTree = new BSTree<>();
        stringBSTree.insert("C");
        stringBSTree.insert("B");
        stringBSTree.insert("A");
        System.out.println("Printing the tree: ");
        stringBSTree.print();

        System.out.println("\nCreating a Double BSTree");
        BSTree<Double> doubleBSTree = new BSTree<>();
        doubleBSTree.insert(2.5);
        doubleBSTree.insert(8.2);
        doubleBSTree.insert(1.8);
        System.out.println("Printing the tree: ");
        doubleBSTree.print();
    }
}

/**
 * Binary Search Tree class that uses a binary tree to store data
 * Leverages the BSTreeNode class
 * @param <E> the type of data to be stored in the tree
 */
class BSTree<E extends Comparable<E>> {
    private TreeNode root;

    public BSTree() {
       this.root = null;
    }

    public BSTree(TreeNode root) {
        this.root = root;
    }

    /**
     * Inserts a new node into the tree
     * @param comp the data to be stored in the new node
     */
    public void insert(Comparable<E> comp) {
        root = insert(root, comp);
    }

    /**
     * Prints the tree using an inorder traversal
     */
    public void print() {
        print(root);
    }

    /**
     * Clears the tree
     */
    public void clear() {
        root = null;
    }

    /**
     * Helper method for the insert method
     * @param node the node to be inserted into
     * @param comp the data to be stored in the new node
     */
    private TreeNode insert(TreeNode node, Comparable<E> comp) {
        if (node == null) {
            return new TreeNode(comp);
        }
        if (comp.compareTo((E) node.getValue()) < 0) {
            node.setLeft(insert(node.getLeft(), comp));
        } else {
            node.setRight(insert(node.getRight(), comp));
        }
        return node;
    }

    /**
     * Helper method for the print method
     * @param node the node to be printed from
     */
    private void print(TreeNode node) {
        if (node != null) {
            print(node.getLeft());
            System.out.println(node.getValue());
            print(node.getRight());
        }
    }
}

class TreeNode {
    private Object value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(Object initValue) {
        value = initValue;
        left = null;
        right = null;
    }

    public TreeNode(Object initValue, TreeNode initLeft, TreeNode initRight) {
        value = initValue;
        left = initLeft;
        right = initRight;
    }

    public Object getValue() { return value; }
    public TreeNode getLeft() { return left; }
    public TreeNode getRight() { return right; }

    public void setValue(Object theNewValue) { value = theNewValue; }
    public void setLeft(TreeNode theNewLeft) { left = theNewLeft; }
    public void setRight(TreeNode theNewRight) { right = theNewRight; }
}
