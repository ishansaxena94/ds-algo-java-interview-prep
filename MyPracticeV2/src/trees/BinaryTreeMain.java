package trees;

import trees.BinaryTree.Node;

public class BinaryTreeMain {

	public static void main(String[] args) {

		// ---------------------------------------------------------------------------------------
		// ***** SIMPLE TRAVERSALS (RECURSIVE + ITERATIVE) *****
		System.out.println("***** SIMPLE TRAVERSALS (RECURSIVE + ITERATIVE) *****");

		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Preorder traversal of binary tree is ");
		tree.printPreorder();
		System.out.println();
		tree.printPreorderItervative();

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
		tree_level.root = new Node(1);
		tree_level.root.left = new Node(2);
		tree_level.root.right = new Node(3);
		tree_level.root.left.left = new Node(4);
		tree_level.root.left.right = new Node(5);

		System.out.println("\nLevel order traversal of binary tree is - ");
		tree_level.printLevelOrder();

		BinaryTree treeGivenLevel = new BinaryTree();
		System.out.println();

		/*
		 * Constructed binary tree is 1 / \ 2 3 / \ / 4 5 8
		 */
		treeGivenLevel.root = new Node(1);
		treeGivenLevel.root.left = new Node(2);
		treeGivenLevel.root.right = new Node(3);
		treeGivenLevel.root.left.left = new Node(4);
		treeGivenLevel.root.left.right = new Node(5);
		treeGivenLevel.root.right.left = new Node(8);

		System.out.println("Nodes at given level 2: ");
		treeGivenLevel.printGivenLevel(2);
		System.out.println();

		// ---------------------------------------------------------------------------------------
		// ***** VIEWS *****
		System.out.println("\n***** VIEWS *****");

		// Left View
		BinaryTree treeView = new BinaryTree();
		treeView.root = new Node(12);
		treeView.root.left = new Node(10);
		treeView.root.right = new Node(30);
		treeView.root.right.left = new Node(25);
		treeView.root.right.right = new Node(40);

		System.out.println("Left View: ");
		treeView.printLeftView();
		System.out.println();

		// Right View
		System.out.println("Right View: ");
		treeView.printRightView();
		System.out.println();

		// Top View
		BinaryTree treeView2 = new BinaryTree();
		treeView2.root = new Node(1);
		treeView2.root.left = new Node(2);
		treeView2.root.right = new Node(3);
		treeView2.root.left.right = new Node(4);
		treeView2.root.left.right.right = new Node(5);
		treeView2.root.left.right.right.right = new Node(6);
		System.out.println("Following are nodes in TOP view of Binary Tree");
		treeView2.printTopView();
		System.out.println();

		// Bottom View
		System.out.println("Following are nodes in BOTTOM view of Binary Tree");
		treeView2.printBottomView();
		System.out.println();

		// ---------------------------------------------------------------------------------------
		// ***** HARD *****

		System.out.println("\n***** HARD *****");

		BinaryTree treeKDistance = new BinaryTree();
		treeKDistance.root = new Node(20);
		treeKDistance.root.left = new Node(8);
		treeKDistance.root.right = new Node(22);
		treeKDistance.root.left.left = new Node(4);
		treeKDistance.root.left.right = new Node(12);
		treeKDistance.root.left.right.left = new Node(10);
		treeKDistance.root.left.right.right = new Node(14);
		Node target = treeKDistance.root.left.right;
		System.out.println("Nodes at k distance: ");
		treeKDistance.printNodesAtKDistance(target, 2);
	}

}
