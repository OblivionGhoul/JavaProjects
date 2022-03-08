public class NodeDeletionTester {
    public static void main(String[] args) {
        System.out.println("Creating an integer BSTree");
        BSTree<Integer> tree = new BSTree<>();
        System.out.println("Adding elements (1-10).");
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
        System.out.println("\nPrinting the post order of the tree.");
        tree.printPostOrder();
        System.out.println("\nPrinting the pre order of the tree.");
        tree.printPreOrder();

        System.out.println("\nRemoving the nodes with values 6-10.");
        System.out.println("Removed Value: " + tree.remove(6));
        System.out.println("Removed Value: " + tree.remove(7));
        System.out.println("Removed Value: " + tree.remove(8));
        System.out.println("Removed Value: " + tree.remove(9));
        System.out.println("Removed Value: " + tree.remove(10));
        System.out.println("Printing updated the tree: ");
        tree.print();
        System.out.println("\nPrinting the post order of the tree.");
        tree.printPostOrder();
        System.out.println("\nPrinting the pre order of the tree.");
        tree.printPreOrder();
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
     * Prints the post order of the tree
     */
    public void printPostOrder() {
        printPostOrder(root);
    }

    /**
     * Prints the pre-order of the tree
     */
    public void printPreOrder() {
        printPreOrder(root);
    }

    /**
     * Removes a node from the tree
     * @param comp the data to be removed
     * @return the data that was removed
     */
    public E remove(Comparable<E> comp) {
        root = remove(root, comp);
        return (E) comp;
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

    /**
     * Helper method for the remove method
     * @param node the node to be removed from
     * @param comp the data to be removed
     * @return the node that was removed
     */
    private TreeNode remove(TreeNode node, Comparable<E> comp) {
        if (node == null) {
            return null;
        }
        if (comp.compareTo((E) node.getValue()) < 0) {
            node.setLeft(remove(node.getLeft(), comp));
        } else if (comp.compareTo((E) node.getValue()) > 0) {
            node.setRight(remove(node.getRight(), comp));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }
            node.setValue(findMin(node.getRight()).getValue());
            node.setRight(remove(node.getRight(), (E) node.getValue()));
        }
        return node;
    }

    /**
     * Helper method for the remove method
     * @param node the node to be removed from
     * @return the node with the smallest value
     */
    private TreeNode findMin(TreeNode node) {
        if (node.getLeft() == null) {
            return node;
        }
        return findMin(node.getLeft());
    }

    /**
     * Helper method for the printPostOrder method
     * @param node the node to be printed from
     */
    private void printPostOrder(TreeNode node) {
        if (node != null) {
            printPostOrder(node.getLeft());
            printPostOrder(node.getRight());
            System.out.println(node.getValue());
        }
    }

    /**
     * Helper method for the printPreOrder method
     * @param node the node to be printed from
     */
    private void printPreOrder(TreeNode node) {
        if (node != null) {
            System.out.println(node.getValue());
            printPreOrder(node.getLeft());
            printPreOrder(node.getRight());
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
