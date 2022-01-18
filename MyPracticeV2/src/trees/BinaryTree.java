package trees;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class BinaryTree {

	static class Node {
		int data;
		public Node left, right;

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

	// head --> Pointer to head node of created doubly linked list
	Node head;

	// Initialize previously visited node as NULL. This is
	// static so that the same value is accessible in all recursive
	// calls
	static Node prev = null;

	private class Pair {
		int height;
		int val;

		public Pair(int height, int val) {
			this.height = height;
			this.val = val;
		}

	}

	private class MyNodeInfo{
		int size;
		int min, max;
		Boolean isBST;

		public MyNodeInfo() {
			this.size = 0;
			this.min = 0;
			this.max = 0;
			this.isBST = false;
		}

		public MyNodeInfo(int size, int min, int max, Boolean isBST)
		{
			this.size = size;
			this.min = min;
			this.max = max;
			this.isBST = isBST;
		}

	}

	// ---------------------------------------------------------------------------------------
	// ***** GLOBAL VARIABLES *****
	static int maxLevel = 0;
	static int maxDiameter = 0;
	static int maxSum = 0;

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

	void printPreorderIterative() {

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

			while (cur != null) {	// go to the leftmost child
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

	// 6. print each level in next line
	void printLevelOrder2()
	{
		// Base Case
		if(root == null)
			return;

		// Create an empty queue for level order tarversal
		Queue<Node> q =new LinkedList<>();

		// Enqueue Root and initialize height
		q.add(root);

		while(true)
		{
			// nodeCount (queue size) indicates number of nodes
			// at current level.
			int nodeCount = q.size();
			if(nodeCount == 0)
				break;

			// Dequeue all nodes of current level and
			// Enqueue all nodes of next level
			while(nodeCount > 0)
			{
				Node node = q.remove();
				System.out.print(node.data + " ");

				if(node.left != null)
					q.add(node.left);
				if(node.right != null)
					q.add(node.right);

				nodeCount--;
			}

			System.out.println();
		}
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

	public int diameterUtil2(Node root){

		if(null == root)
			return 0;

		int leftHeight = diameterUtil2(root.left);
		int rightHeight = diameterUtil2(root.right);

		maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

		return Math.max(leftHeight, rightHeight) + 1;
	}

	/* A wrapper over diameter(Node root) */
	int diameter() {
		return diameterUtil(root);
	}

	// 3. LCA of BT
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
		if (null == node)
			return true;

		/* false if this node violates the min/max constraints */
		if (node.data < min || node.data > max)
			return false;

		/*
		 * otherwise check the subtrees recursively tightening the min/max constraints
		 */
		// Allow only distinct values
		return (isBSTUtil(node.left, min, node.data - 1) &&	// recur left
				isBSTUtil(node.right, node.data + 1, max));	// recur right
	}

	boolean isBST() {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	// ---------------------------------------------------------------------------------------
	// ***** MEDIUM *****

	// 1. Convert BT to its Mirror
	private Node mirror(Node node){

		if(null == node)
			return null;

		Node left = mirror(node.left);
		Node right = mirror(node.right);

		node.left = right;
		node.right = left;

		return node;
	}

	// 2. Check if 2 trees are Isomorphic
	boolean isIsomorphic(Node n1, Node n2) {

		// Both roots are NULL, trees isomorphic by definition
		if(null == n1 && null == n2)
			return true;

		// Exactly one of the n1 and n2 is NULL, trees not isomorphic
		if(null != n1 || null != n2)
			return false;

		if(n1.data != n2.data)
			return false;

		// There are two possible cases for n1 and n2 to be isomorphic
		// Case 1: The subtrees rooted at these nodes have NOT been
		// "Flipped".
		// Both of these subtrees have to be isomorphic.
		// Case 2: The subtrees rooted at these nodes have been "Flipped"
		return ((isIsomorphic(n1.left, n2.left) || isIsomorphic(n1.left, n2.right)) &&
				(isIsomorphic(n1.right, n2.right) || isIsomorphic(n1.right, n2.left)));
	}

	// 3. Connect Nodes at same level

	// 4. Zig-Zag traversal

	// 5. Boundary Traversal
	/*
	We break the problem in 3 parts:
			1. Print the left boundary in top-down manner.
			2. Print all leaf nodes from left to right, which can again be sub-divided into two sub-parts:
				2.1 Print all leaf nodes of left sub-tree from left to right.
				2.2 Print all leaf nodes of right subtree from left to right.
			3. Print the right boundary in bottom-up manner.
	 */

	// 6. Vertical Order Print
	// Map based impl

	// 7. Max Sum Path - Find the maximum sum leaf to root path in a Binary Tree
	private int maxSumPathUtil(Node node){
		return 0;
	}

	// 8. Max Sum Path 2 - Find the maximum sum leaf to root path in a Binary Tree
	// A utility function to find the maximum sum between any two leaves.This function calculates two values:
	// 1) Maximum path sum between two leaves which is stored in res.
	// 2) The maximum root to leaf path sum which is returned.
	// If one side of root is empty, then it returns INT_MIN
	private int maxSumPathBw2LeafUtil(Node node){

		if(null == node)
			return 0;

		if(node.left == null && node.right == null)
			return node.data;

		// Find maximum sum in left and right subtree. Also
		// find maximum root to leaf sums in left and right
		// subtrees and store them in ls and rs
		int leftSum = maxSumPathBw2LeafUtil(node.left);
		int rightSum = maxSumPathBw2LeafUtil(node.right);

		maxSum = Math.max(maxSum, (leftSum + rightSum + node.data));
		System.out.println("Max Sum at " + node.data + " is " + maxSum);

		return Math.max(leftSum, rightSum) + node.data;
	}

	int maxSumPathBw2Leaf(Node node){
		if(null == node)
			return 0;

		maxSumPathBw2LeafUtil(node);
		return maxSum;
	}

	// ---------------------------------------------------------------------------------------
	// ***** HARD *****

	// 1. print Nodes at k distance from a node
	int printNodesAtKDistanceUtil(Node node, int target, int k) {

		if (null == node)
			return -1;

		if (node.data == target) {
			// print downstream nodes at distance k
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

	// 2. Largest BST in a BT
	MyNodeInfo largestBSTinBTUtil(Node node){

		if(null == node)
			return new MyNodeInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);

		if(node.left == null && node.right == null)
			return new MyNodeInfo(1, node.data, node.data, true);

		MyNodeInfo left = largestBSTinBTUtil(node.left);
		MyNodeInfo right = largestBSTinBTUtil(node.right);

		MyNodeInfo returnInfo = new MyNodeInfo();

		if((left.isBST && right.isBST) &&
		   left.max < node.data &&
		   right.min > node.data){

			returnInfo.isBST = true;
			returnInfo.size = left.size + right.size + 1;

			returnInfo.min = root.left != null ? left.min : root.data;
			returnInfo.max = root.right != null ? right.max : root.data;

			return returnInfo;
		}

		// If whole tree is not BST, return maximum
		// of left and right subtrees
		returnInfo.size = Math.max(left.size, right.size);
		returnInfo.isBST = false;

		return returnInfo;
	}

	int largestBSTinBT(Node node){

		return largestBSTinBTUtil(node).size;
	}

	// 3. BST||BT to DLL
	void BinaryTree2DoubleLinkedList(Node root)
	{
		// Base case
		if (root == null)
			return;

		// Recursively convert left subtree
		BinaryTree2DoubleLinkedList(root.left);

		// Now convert this node
		if (prev == null)
			head = root;
		else
		{
			root.left = prev;
			prev.right = root;
		}
		prev = root;

		// Finally convert right subtree
		BinaryTree2DoubleLinkedList(root.right);
	}

	// 4. Burning Tree

	// ---------------------------------------------------------------------------------------
	// ***** CONSTRUCTION *****

	// 1. Construct a complete binary tree from given array in level order fashion

	// 2. Construct BT from Preorder and Inorder - Easier

	// 3. Construct BT from Inorder and Postorder

	// 4. Construct BT from Preorder and Postorder
}
