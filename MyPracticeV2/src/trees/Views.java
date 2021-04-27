package trees;

public class Views
{
    public static void main(String[] args)
    {
        // ---------------------------------------------------------------------------------------
        // ***** VIEWS *****
        System.out.println("\n***** VIEWS *****");

        // Left View
        BinaryTree treeView = new BinaryTree();
        treeView.root = new BinaryTree.Node(12);
        treeView.root.left = new BinaryTree.Node(10);
        treeView.root.right = new BinaryTree.Node(30);
        treeView.root.right.left = new BinaryTree.Node(25);
        treeView.root.right.right = new BinaryTree.Node(40);

        System.out.println("Left View: ");
        treeView.printLeftView();
        System.out.println();

        // Right View
        System.out.println("Right View: ");
        treeView.printRightView();
        System.out.println();

        // Top View
        BinaryTree treeView2 = new BinaryTree();
        treeView2.root = new BinaryTree.Node(1);
        treeView2.root.left = new BinaryTree.Node(2);
        treeView2.root.right = new BinaryTree.Node(3);
        treeView2.root.left.right = new BinaryTree.Node(4);
        treeView2.root.left.right.right = new BinaryTree.Node(5);
        treeView2.root.left.right.right.right = new BinaryTree.Node(6);
        System.out.println("Following are nodes in TOP view of Binary Tree");
        treeView2.printTopView();
        System.out.println();

        // Bottom View
        System.out.println("Following are nodes in BOTTOM view of Binary Tree");
        treeView2.printBottomView();
        System.out.println();
    }
}
