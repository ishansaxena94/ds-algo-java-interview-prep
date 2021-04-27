package trees;

public class Medium
{
    public static void main(String[] args)
    {
        // ---------------------------------------------------------------------------------------
        // ***** MEDIUM *****

        System.out.println("\n***** MEDIUM *****");

        BinaryTree treeMaxSumBw2Leaf = new BinaryTree();
        treeMaxSumBw2Leaf.root = new BinaryTree.Node(-15);
        treeMaxSumBw2Leaf.root.left = new BinaryTree.Node(5);
        treeMaxSumBw2Leaf.root.right = new BinaryTree.Node(6);
        treeMaxSumBw2Leaf.root.left.left = new BinaryTree.Node(-8);
        treeMaxSumBw2Leaf.root.left.right = new BinaryTree.Node(1);
        treeMaxSumBw2Leaf.root.left.left.left = new BinaryTree.Node(2);
        treeMaxSumBw2Leaf.root.left.left.right = new BinaryTree.Node(6);
        treeMaxSumBw2Leaf.root.right.left = new BinaryTree.Node(3);
        treeMaxSumBw2Leaf.root.right.right = new BinaryTree.Node(9);
        treeMaxSumBw2Leaf.root.right.right.right = new BinaryTree.Node(0);
        treeMaxSumBw2Leaf.root.right.right.right.left = new BinaryTree.Node(4);
        treeMaxSumBw2Leaf.root.right.right.right.right = new BinaryTree.Node(-1);
        treeMaxSumBw2Leaf.root.right.right.right.right.left = new BinaryTree.Node(10);
        System.out.println("Max pathSum of the given binary treeMaxSumBw2Leaf is "
                           + treeMaxSumBw2Leaf.maxSumPathBw2Leaf(treeMaxSumBw2Leaf.root));
    }
}
