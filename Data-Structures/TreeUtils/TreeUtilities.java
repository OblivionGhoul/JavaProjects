//A container for useful static methods that operate on TreeNode objects.
public class TreeUtilities {
    //the random object used by this class
    private static final java.util.Random random = new java.util.Random();

    // main method for testing
    public static void main(String[] args) {
//        System.out.println("Making a tree of depth 5");
//        TreeNode t = createRandom(5);
//        TreeDisplay display = new TreeDisplay();
//
//        System.out.println("Displaying the tree");
//        display.displayTree(t);
//
//        System.out.println("\nThe leftmost node is " + leftmost(t));
//        System.out.println("The rightmost node is " + rightmost(t));
//        System.out.println("The maximum depth of the tree is " + maxDepth(t));
//        System.out.println("Number of nodes in the tree is " + countNodes(t));
//        System.out.println("Number of leaves in the tree is " + countLeaves(t));
//        System.out.println("The sum of all the nodes is " + sum(t));
//
//        System.out.println("\nDisplaying pre-order traversal");
//        preOrder(t, display);
//        System.out.println("Displaying in-order traversal");
//        inOrder(t, display);
//        System.out.println("Displaying post-order traversal");
//        postOrder(t, display);
//
//        System.out.println("\nMaking a second tree, which is a copy of tree 1");
//        TreeNode t2 = copy(t);
//        System.out.println("Displaying the second tree");
//        display.displayTree(t2);
//        System.out.println("Checking if the two trees have the same shape: " + sameShape(t, t2));

        System.out.println("Creating a decoding tree and display.");
        TreeDisplay morseCodeDisplay = new TreeDisplay();
        TreeNode morseCodeTree = createDecodingTree(morseCodeDisplay, false);

        System.out.println("Translating \"Minh is cool\" from morse code to words (-- .. -. .... .. ... -.-. --- --- .-..):");
        System.out.println("Morse code translation: " + decodeMorse(morseCodeTree, "-- .. -. ....", morseCodeDisplay, false));
        System.out.println("Morse code translation: " + decodeMorse(morseCodeTree, ".. ...", morseCodeDisplay, false));
        System.out.println("Morse code translation: " + decodeMorse(morseCodeTree, "-.-. --- --- .-..", morseCodeDisplay, false));

        System.out.println("Testing invalid morse code: " + decodeMorse(morseCodeTree, ".. .........", morseCodeDisplay, false));
    }

    //precondition:  t is non-empty
    //post-condition: returns the value in the leftmost node of t.
    public static Object leftmost(TreeNode t) {
        //Implement using a while loop (no recursion)
        while (t.getLeft() != null) {
            t = t.getLeft();
        }
        return t.getValue();
    }

    //precondition:  t is non-empty
    //post-condition: returns the value in the rightmost node of t.
    public static Object rightmost(TreeNode t) {
        //Implement using recursion (no loops)
        if (t.getRight() == null) {
            return t.getValue();
        }
        return rightmost(t.getRight());
    }

    //post-condition: returns the maximum depth of t, where an empty tree
    //               has depth 0, a tree with one node has depth 1, etc
    public static int maxDepth(TreeNode t) {
        if (t == null) {
            return 0;
        }
        int left = maxDepth(t.getLeft());
        int right = maxDepth(t.getRight());
        return Math.max(left, right) + 1;
    }

    //post-condition: each node in t has been lit up on display
    //               in a pre-order traversal
    public static void preOrder(TreeNode t, TreeDisplay display) {
        if (t != null) {
            display.visit(t);
            preOrder(t.getLeft(), display);
            preOrder(t.getRight(), display);
        }
    }

    //post-condition: each node in t has been lit up on display
    //               in an in-order traversal
    public static void inOrder(TreeNode t, TreeDisplay display) {
        if (t != null) {
            inOrder(t.getLeft(), display);
            display.visit(t);
            inOrder(t.getRight(), display);
        }
    }

    //post-condition: each node in t has been lit up on display
    //               in a post-order traversal
    public static void postOrder(TreeNode t, TreeDisplay display) {
        if (t != null) {
            postOrder(t.getLeft(), display);
            postOrder(t.getRight(), display);
            display.visit(t);
        }
    }

    //useful method for building a randomly shaped
    //tree of a given maximum depth
    public static TreeNode createRandom(int depth) {
        if (random.nextInt((int)Math.pow(2, depth)) == 0)
            return null;
        return new TreeNode(random.nextInt(10),
                createRandom(depth - 1),
                createRandom(depth - 1));
    }

    //returns the number of nodes in t
    public static int countNodes(TreeNode t) {
        if (t == null) {
            return 0;
        }
        return 1 + countNodes(t.getLeft()) + countNodes(t.getRight());
    }

    //returns the number of leaves in t
    public static int countLeaves(TreeNode t) {
        if (t == null) {
            return 0;
        }
        if (t.getLeft() == null && t.getRight() == null) {
            return 1;
        }
        return countLeaves(t.getLeft()) + countLeaves(t.getRight());
    }

    //precondition:  all values in t are Integer objects
    //post-condition: returns the sum of all values in t
    public static int sum(TreeNode t) {
        if (t == null) {
            return 0;
        }
        return (Integer)t.getValue() + sum(t.getLeft()) + sum(t.getRight());
    }

    //post-condition:  returns a new tree, which is a complete copy
    //                of t with all new TreeNode objects pointing
    //                to the same values as t (in the same order, shape, etc)
    public static TreeNode copy(TreeNode t) {
        if (t == null) {
            return null;
        }
        return new TreeNode(t.getValue(), copy(t.getLeft()), copy(t.getRight()));
    }

    //post-condition:  returns true if t1 and t2 have the same
    //                shape (but not necessarily the same values);
    //                otherwise, returns false
    public static boolean sameShape(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return sameShape(t1.getLeft(), t2.getLeft())
                && sameShape(t1.getRight(), t2.getRight());
    }

    //post-condition:  returns a tree for decoding Morse code
    public static TreeNode createDecodingTree(TreeDisplay display, boolean shouldDisplay) {
        TreeNode tree = new TreeNode("Morse Tree");
        display.displayTree(tree);
        insertMorse(tree, "a", ".-", display, shouldDisplay);
        insertMorse(tree, "b", "-...", display, shouldDisplay);
        insertMorse(tree, "c", "-.-.", display, shouldDisplay);
        insertMorse(tree, "d", "-..", display, shouldDisplay);
        insertMorse(tree, "e", ".", display, shouldDisplay);
        insertMorse(tree, "f", "..-.", display, shouldDisplay);
        insertMorse(tree, "g", "--.", display, shouldDisplay);
        insertMorse(tree, "h", "....", display, shouldDisplay);
        insertMorse(tree, "i", "..", display, shouldDisplay);
        insertMorse(tree, "j", ".---", display, shouldDisplay);
        insertMorse(tree, "k", "-.-", display, shouldDisplay);
        insertMorse(tree, "l", ".-..", display, shouldDisplay);
        insertMorse(tree, "m", "--", display, shouldDisplay);
        insertMorse(tree, "n", "-.", display, shouldDisplay);
        insertMorse(tree, "o", "---", display, shouldDisplay);
        insertMorse(tree, "p", ".--.", display, shouldDisplay);
        insertMorse(tree, "q", "--.-", display, shouldDisplay);
        insertMorse(tree, "r", ".-.", display, shouldDisplay);
        insertMorse(tree, "s", "...", display, shouldDisplay);
        insertMorse(tree, "t", "-", display, shouldDisplay);
        insertMorse(tree, "u", "..-", display, shouldDisplay);
        insertMorse(tree, "v", "...-", display, shouldDisplay);
        insertMorse(tree, "w", ".--", display, shouldDisplay);
        insertMorse(tree, "x", "-..-", display, shouldDisplay);
        insertMorse(tree, "y", "-.--", display, shouldDisplay);
        insertMorse(tree, "z", "--..", display, shouldDisplay);
        return tree;
    }

    //post-condition:  inserts the given letter into the decodingTree,
    //                in the appropriate position, as determined by
    //                the given Morse code sequence; lights up the display
    //                as it walks down the tree
    private static void insertMorse(TreeNode decodingTree, String letter,
                                    String code, TreeDisplay display, boolean shouldDisplay) {
        if (shouldDisplay) display.visit(decodingTree);

        if (code.length() == 0) {
            decodingTree.setValue(letter);
        } else if(code.charAt(0) == '-') {
            if (decodingTree.getRight() == null) {
                decodingTree.setRight(new TreeNode(""));
            }

            insertMorse(decodingTree.getRight(), letter, code.substring(1), display, shouldDisplay);
        } else if(code.charAt(0) == '.') {
            if (decodingTree.getLeft() == null) {
                decodingTree.setLeft(new TreeNode(""));
            }

            insertMorse(decodingTree.getLeft(), letter, code.substring(1), display, shouldDisplay);
        }
    }

    //precondition:  ciphertext is Morse code, consisting of dots, dashes, and spaces
    //post-condition: uses the given decodingTree to return the decoded message;
    //               lights up the display as it walks down the tree
    public static String decodeMorse(TreeNode decodingTree, String cipherText, TreeDisplay display, boolean shouldDisplay) {
        StringBuilder res = new StringBuilder();
        TreeNode currTree = decodingTree;
        String invalidCode = "INVALID MORSE CODE!";

        while(!cipherText.equals("")) {
            if (shouldDisplay) display.visit(decodingTree);

            if (cipherText.startsWith(" ")) {
                if (decodingTree.getValue() != null) {
                    res.append(decodingTree.getValue());
                    decodingTree = currTree;
                } else {
                    return invalidCode;
                }
            } else if (cipherText.startsWith("-")) {
                if (decodingTree.getRight() != null) {
                    decodingTree = decodingTree.getRight();
                } else {
                    return invalidCode;
                }
            } else if (cipherText.startsWith(".")) {
                if (decodingTree.getLeft() != null) {
                    decodingTree = decodingTree.getLeft();
                } else {
                    return invalidCode;
                }
            }
            cipherText = cipherText.substring(1);
        }

        return res.append(decodingTree.getValue()).toString();
    }
}