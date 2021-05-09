package com.java.practice.testglider;

import java.util.*; 


class BinarySearchTree {

	private class Node {
		int key;
		Node left, right;

		public Node(int item) {
			key = item;
			left = right = null;
		}
	}
	Node root;

	BinarySearchTree() {
		root = null;
	}

	Node insertRec(Node root, int key) {
		if(root == null) {
			root = new Node(key);
			return root;
		}
		if (key < root.key) {
			root.left = insertRec(root.left, key);
		}
		else if (key > root.key) {
			root.right = insertRec(root.right, key);
		}
		return root;
	}
	
	void insert(int key) {
		root = insertRec(root, key);
	}
	
	
	int getParent(int key) {
	    int result = -1;
		// Write your code here
		
		return result;
	}

}


class BST {
    
	private static int solve(int[] arr, int n, int k) {
		int result = 0;
		BinarySearchTree bst = new BinarySearchTree();
		for(int i = 0; i < n; i++) {
			bst.insert(arr[i]);
		}
		bst.insert(k);
		result = bst.getParent(k);
		return result;
	}

    public static void main(String[] args) { 
       Scanner in = new Scanner(System.in); 
       // Click HELP above to see examples of handling input/debug/output 
       // INPUT: int n = in.nextInt(); 
       // DEBUG: System.out.println(n); 
       // OUTPUT: System.out.println(result); 

       // Write the code to solve the problem below, 
       // format the "result" as specified in the problem statement 
       // and finally, write the result to stdout 
       // IMPORTANT: Remove all debug statements for final submission
		int n = in.nextInt();
		int k = in.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println(solve(arr, n, k));
		in.close();
    } 
} 
