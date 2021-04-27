package trees;

public class Traversals
{
    public static void main(String[] args)
    {
        // ---------------------------------------------------------------------------------------
        // ***** SIMPLE TRAVERSALS (RECURSIVE + ITERATIVE) *****
        System.out.println("***** SIMPLE TRAVERSALS (RECURSIVE + ITERATIVE) *****");

        BinaryTree tree = new BinaryTree();
        tree.root = new BinaryTree.Node(1);
        tree.root.left = new BinaryTree.Node(2);
        tree.root.right = new BinaryTree.Node(3);
        tree.root.left.left = new BinaryTree.Node(4);
        tree.root.left.right = new BinaryTree.Node(5);

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder();
        System.out.println();
        tree.printPreorderIterative();

        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder();
        System.out.println();
        tree.printInorderItervative();

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder();
        System.out.println();
        tree.printPostorderItervative();

        // Level order
        BinaryTree tree_level = new BinaryTree();
        tree_level.root = new BinaryTree.Node(1);
        tree_level.root.left = new BinaryTree.Node(2);
        tree_level.root.right = new BinaryTree.Node(3);
        tree_level.root.left.left = new BinaryTree.Node(4);
        tree_level.root.left.right = new BinaryTree.Node(5);

        System.out.println("\nLevel order traversal of binary tree is - ");
        tree_level.printLevelOrder();

        BinaryTree treeGivenLevel = new BinaryTree();
        System.out.println();

        /*
         * Constructed binary tree is 1 / \ 2 3 / \ / 4 5 8
         */
        treeGivenLevel.root = new BinaryTree.Node(1);
        treeGivenLevel.root.left = new BinaryTree.Node(2);
        treeGivenLevel.root.right = new BinaryTree.Node(3);
        treeGivenLevel.root.left.left = new BinaryTree.Node(4);
        treeGivenLevel.root.left.right = new BinaryTree.Node(5);
        treeGivenLevel.root.right.left = new BinaryTree.Node(8);

        System.out.println("Nodes at given level 2: ");
        treeGivenLevel.printGivenLevel(2);
        System.out.println();
    }
}
