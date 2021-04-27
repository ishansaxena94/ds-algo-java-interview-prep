package trees;

public class Hard
{
    public static void main(String[] args)
    {
        // ---------------------------------------------------------------------------------------
        // ***** HARD *****

        System.out.println("\n***** HARD *****");

        BinaryTree treeKDistance = new BinaryTree();
        treeKDistance.root = new BinaryTree.Node(20);
        treeKDistance.root.left = new BinaryTree.Node(8);
        treeKDistance.root.right = new BinaryTree.Node(22);
        treeKDistance.root.left.left = new BinaryTree.Node(4);
        treeKDistance.root.left.right = new BinaryTree.Node(12);
        treeKDistance.root.left.right.left = new BinaryTree.Node(10);
        treeKDistance.root.left.right.right = new BinaryTree.Node(14);
        BinaryTree.Node target = treeKDistance.root.left.right;
        System.out.print("Nodes at k distance: ");
        treeKDistance.printNodesAtKDistance(target, 2);

        // Largest BST in BT
        /* Let us construct the following Tree
                50
             /      \
            10        60
           /  \       /  \
          5   20    55    70
                    /     /  \
                  45    65    80
         */

        BinaryTree treeLargestBSTinBT = new BinaryTree();
        treeLargestBSTinBT.root = new BinaryTree.Node(50);
        treeLargestBSTinBT.root.left = new BinaryTree.Node(10);
        treeLargestBSTinBT.root.right = new BinaryTree.Node(60);
        treeLargestBSTinBT.root.left.left = new BinaryTree.Node(5);
        treeLargestBSTinBT.root.left.right = new BinaryTree.Node(20);

        treeLargestBSTinBT.root.right.left = new BinaryTree.Node(55);
        treeLargestBSTinBT.root.right.left.left = new BinaryTree.Node(45);
        treeLargestBSTinBT.root.right.right = new BinaryTree.Node(70);
        treeLargestBSTinBT.root.right.right.left = new BinaryTree.Node(65);
        treeLargestBSTinBT.root.right.right.right = new BinaryTree.Node(80);

        /* The complete tree is not BST as 45 is in right tree of 50.
         The following tree is the largest BST
             60
            /  \
          55    70
          /     /  \
        45     65   80
        */

        System.out.println("Size of largest BST is " +
                           treeLargestBSTinBT.largestBSTinBT(treeLargestBSTinBT.root)); // 6
    }

}
