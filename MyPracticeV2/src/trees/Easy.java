package trees;

public class Easy
{
    public static void main(String[] args)
    {
        // ---------------------------------------------------------------------------------------
        // ***** HARD *****

        System.out.println("\n***** EASY *****");

        // creating a binary tree and entering the nodes
        BinaryTree tree = new BinaryTree();
        tree.root = new BinaryTree.Node(1);
        tree.root.left = new BinaryTree.Node(2);
        tree.root.right = new BinaryTree.Node(3);
        tree.root.left.left = new BinaryTree.Node(4);
        tree.root.left.right = new BinaryTree.Node(5);

        // Function Call
        System.out.println(
                "1. The diameter of given binary tree is : "
                + tree.diameter());

        System.out.println(
                "2. The diameter of given binary tree is : "
                + tree.diameterUtil2(tree.root));
    }
}
