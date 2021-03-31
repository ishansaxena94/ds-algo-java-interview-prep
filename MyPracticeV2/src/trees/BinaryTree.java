package trees;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class BinaryTree {

	static class Node {
		int data;
		Node left, right;

		Node() {
			data = 0;
			left = null;
			right = null;
		}

		Node(int d) {
			this.data = d;
			left = null;
			right = null;
		}
	}

	Node root;

	private class Pair {
		int height;
		int val;

		public Pair(int height, int val) {
			this.height = height;
			this.val = val;
		}

	}

	// ---------------------------------------------------------------------------------------
	// ***** GLOBAL VARIABLES *****
	static int maxLevel = 0;

	// ---------------------------------------------------------------------------------------
	// ***** SIMPLE TRAVERSALS (RECURSIVE + ITERATIVE) *****

	// 1. Preorder
	private void preorderUtil(Node root) { // Root -> L -> R
		if (null == root)
			return;

		System.out.print(root.data + " ");
		preorderUtil(root.left);
		preorderUtil(root.right);
	}

	void printPreorder() {
		preorderUtil(root);
	}

	void printPreorderItervative() {

		if (null == root)
			return;

		Stack<Node> s = new Stack<>();
		Node cur = root;

		while (!s.empty() || null != cur) {

			while (null != cur) { // print all left elements of a subtree
				System.out.print(cur.data + " ");

				if (cur.right != null) // add right child to stack
					s.push(cur.right);

				cur = cur.left; // traverse left
			}

			// cur is null a this point
			// pop the right child and continue

			if (!s.empty())
				cur = s.pop();
		}
	}

	// 2. Inorder
	private void inorderUtil(Node root) { // L -> Root -> Right

		if (null == root)
			return;

		inorderUtil(root.left);
		System.out.print(root.data + " ");
		inorderUtil(root.right);
	}

	void printInorder() {
		inorderUtil(root);
	}

	void printInorderItervative() {

		if (null == root)
			return;

		Stack<Node> s = new Stack<>();
		Node cur = root;

		while (!s.empty() || null != cur) {

			while (cur != null) {
				s.push(cur);
				cur = cur.left;
			}

			// cur is NULL at this point
			cur = s.pop();

			System.out.print(cur.data + " ");

			cur = cur.right;
		}
	}

	// 3. Postorder
	private void postorderUtil(Node root) { // L -> R -> Root

		if (null == root)
			return;

		postorderUtil(root.left);
		postorderUtil(root.right);
		System.out.print(root.data + " ");
	}

	void printPostorder() {
		postorderUtil(root);
	}

	void printPostorderItervative() {
	}

	// 4. Level Order
	void printLevelOrder() {

		if (null == root)
			return;

		Queue<Node> q = new LinkedList<>();

		q.add(root);
		Node node;

		while (!q.isEmpty()) {

			node = q.remove();

			System.out.print(node.data + " ");

			if (null != node.left)
				q.add(node.left);
			if (null != node.right)
				q.add(node.right);
		}
	}

	// 5. PrintGivenLevel
	private void printGivenLevelUtil(Node node, int curLevel, int level) {

		if (null == node)
			return;

		if (curLevel == level) {
			System.out.print(node.data + " ");
			return;
		}

		if (curLevel < level) {
			printGivenLevelUtil(node.left, curLevel + 1, level);
			printGivenLevelUtil(node.right, curLevel + 1, level);
		}
	}

	void printGivenLevel(int level) {
		printGivenLevelUtil(root, 0, level);
	}

	// NB:Other types of traversals like boundary, zig-zag etc are in medium section

	// ---------------------------------------------------------------------------------------
	// ***** VIEWS *****

	// 1. Left View
	private void leftViewUtil(Node node, int curLevel) {

		if (null == node)
			return;

		if (maxLevel < curLevel) {
			System.out.println(node.data + " ");
			maxLevel = curLevel;
		}

		leftViewUtil(node.left, curLevel + 1);
		leftViewUtil(node.right, curLevel + 1);
	}

	void printLeftView() {
		maxLevel = 0;
		leftViewUtil(root, 1);
	}

	// 2. Right View
	private void rightViewUtil(Node node, int curLevel) {

		if (null == node)
			return;

		if (maxLevel < curLevel) {
			System.out.println(node.data + " ");
			maxLevel = curLevel;
		}

		rightViewUtil(node.right, curLevel + 1);
		rightViewUtil(node.left, curLevel + 1);
	}

	void printRightView() {
		maxLevel = 0;
		rightViewUtil(root, 1);
	}

	// 3. Top View
	private void topViewUtil(Node node, TreeMap<Integer, Pair> map, int hd, int curLevel) { // hd = horizontal distance

		if (null == node)
			return;

		if (null == map.get(hd)) {
			map.put(hd, new Pair(curLevel, node.data));
		} else if (map.get(hd).height > curLevel) { // replace with less height(top) element with same hd
			map.replace(hd, new Pair(curLevel, node.data));
		}

		topViewUtil(node.left, map, hd - 1, curLevel + 1);
		topViewUtil(node.right, map, hd + 1, curLevel + 1);
	}

	void printTopView() {

		if (null == root)
			return;

		TreeMap<Integer, Pair> map = new TreeMap<>();
		topViewUtil(root, map, 0, 0);

		for (Map.Entry<Integer, Pair> ele : map.entrySet()) {
			System.out.print(ele.getValue().val + " ");
		}
	}

	// 4. Bottom View
	private void bottomViewUtil(Node node, TreeMap<Integer, Pair> map, int hd, int curLevel) {

		if (null == node)
			return;

		if (null == map.get(hd)) {
			map.put(hd, new Pair(curLevel, node.data));
		} else if (map.get(hd).height < curLevel) { // Replace with node at greater height with same hd
			map.replace(hd, new Pair(curLevel, node.data));
		}

		bottomViewUtil(node.left, map, hd - 1, curLevel + 1);
		bottomViewUtil(node.right, map, hd + 1, curLevel + 1);
	}

	void printBottomView() {
		if (null == root)
			return;

		TreeMap<Integer, Pair> map = new TreeMap<>();
		bottomViewUtil(root, map, 0, 0);

		for (Map.Entry<Integer, Pair> ele : map.entrySet()) {
			System.out.print(ele.getValue().val + " ");
		}
	}

	// ---------------------------------------------------------------------------------------
	// ***** EASY *****

	// 1. Find height
	private int heightUtil(Node root) {

		if (null == root)
			return 0;

		int leftHeight = heightUtil(root.left);
		int rightHeight = heightUtil(root.right);

		return (Math.max(leftHeight, rightHeight) + 1);
	}

	int height() {
		return heightUtil(root);
	}

	// 2. Find Diameter
	private int diameterUtil(Node root) {
		/* base case if tree is empty */
		if (root == null)
			return 0;

		/* get the height of left and right sub trees */
		int lheight = heightUtil(root.left);
		int rheight = heightUtil(root.right);

		/* get the diameter of left and right subtrees */
		int ldiameter = diameterUtil(root.left);
		int rdiameter = diameterUtil(root.right);

		/*
		 * Return max of following three 1) Diameter of left subtree 2) Diameter of
		 * right subtree 3) Height of left subtree + height of right subtree + 1
		 */
		return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
	}

	/* A wrapper over diameter(Node root) */
	int diameter() {
		return diameterUtil(root);
	}

	// 3. LCA
	Node findLCAUtil(Node node, Node n1, Node n2) {

		if (null == node)
			return null;

		if (node.data == n1.data || node.data == n2.data) {
			return node;
		}

		Node left = findLCAUtil(node.left, n1, n2);
		Node right = findLCAUtil(node.right, n1, n2);

		if (left != null && right != null)
			return node;

		return (left == null ? right : left);

	}

	Node findLCA(Node n1, Node n2) {
		return findLCAUtil(root, n1, n2);
	}

	// 4. Check if 2 Binary Trees are identical
	boolean identicalTrees(Node a, Node b) {
		/* 1. both empty */
		if (a == null && b == null)
			return true;

		/* 2. one empty, one not -> false */
		if (a == null || b == null)
			return false;

		/* 3. both non-empty -> compare them */
		return (a.data == b.data && identicalTrees(a.left, b.left) && identicalTrees(a.right, b.right));
	}

	// 5. Check if BT is BST
	boolean isBSTUtil(Node node, int min, int max) {
		/* an empty tree is BST */
		if (node == null)
			return true;

		/* false if this node violates the min/max constraints */
		if (node.data < min || node.data > max)
			return false;

		/*
		 * otherwise check the subtrees recursively tightening the min/max constraints
		 */
		// Allow only distinct values
		return (isBSTUtil(node.left, min, node.data - 1) && isBSTUtil(node.right, node.data + 1, max));
	}

	boolean isBST() {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	// ---------------------------------------------------------------------------------------
	// ***** MEDIUM *****

	// 1. Convert BT to its Mirror
	void getMirror(Node node) {
	}

	// 2. Check if 2 trees are Isomorphic
	boolean isIsomorphic(Node n1, Node n2) {
		return false;
	}

	// BST||BT to DLL

	// Max Sum Path - Find the maximum sum leaf to root path in a Binary Tree

	// Max Sum Path 2 - Find the maximum sum leaf to root path in a Binary Tree

	// Largest BST in a BT

	// ---------------------------------------------------------------------------------------
	// ***** HARD *****
	// TODO

	// 1. print Nodes at k distance from a node
	int printNodesAtKDistanceUtil(Node node, int target, int k) {

		if (null == node)
			return -1;

		if (node.data == target) {
			printGivenLevelUtil(node, 0, k);
			return 1;
		}

		// Recur for L and R subtree. If node is not found, return -1
		int leftDistance = printNodesAtKDistanceUtil(node.left, target, k);

		if (leftDistance != -1) {

			if (leftDistance == k) {
				System.out.println(node.data + " ");
			} else
				printGivenLevelUtil(node.right, 0, k - leftDistance - 1);

			return 1 + leftDistance;
		}

		int rightDistance = printNodesAtKDistanceUtil(node.right, target, k);

		if (rightDistance != -1) {

			if (rightDistance == k) {
				System.out.println(node.data + " ");
			} else
				printGivenLevelUtil(node.left, 0, k - rightDistance - 1);

			return 1 + rightDistance;
		}

		return -1;
	}

	void printNodesAtKDistance(Node target, int k) {

		if (null == root)
			return;

		printNodesAtKDistanceUtil(root, target.data, k);
	}

	// >> Construction
	// 2. Construct BT from Preorder and Inorder

	// 3. Construct BT from Inorder and Postorder

	// 4. Construct BT from Preorder and Postorder
}
