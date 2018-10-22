package com.assign4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

import com.assign4.tree_orders.TreeNode;

public class is_bst {
	class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class IsBST {
		class Node {
			int key;
			int left;
			int right;

			Node(int key, int left, int right) {
				this.left = left;
				this.right = right;
				this.key = key;
			}
		}

		int nodes;
		Node[] tree;
		TreeNode[] treeNodes;

		void read() throws IOException {
			int[] key, left, right;

			FastScanner in = new FastScanner();
			nodes = in.nextInt();

			key = new int[nodes];
			left = new int[nodes];
			right = new int[nodes];

			tree = new Node[nodes];
			for (int i = 0; i < nodes; i++) {
				key[i] = in.nextInt();
				left[i] = in.nextInt();
				right[i] = in.nextInt();

				// tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
				tree[i] = new Node(key[i], left[i], right[i]);

				/*
				 * if(treeNodes[i]==null) { treeNodes[i]= new TreeNode(); }
				 * treeNodes[i].key = key[i]; if(left[i]!=-1) {
				 * if(treeNodes[left[i]]==null) { treeNodes[left[i]] = new
				 * TreeNode(); } treeNodes[i].left = treeNodes[left[i]]; }
				 * if(right[i] !=-1) { if(treeNodes[right[i]] ==null) {
				 * treeNodes[right[i]]=new TreeNode(); } treeNodes[i].right =
				 * treeNodes[right[i]]; }
				 */

			}
		}

		boolean isBinarySearchTree() {
			// Check the key with the left and the right
			// left smaller key
			// right bigger key

			if (tree.length == 0)
				return true;

			Queue<BstNode> queue = new ArrayDeque<BstNode>();
			queue.add(new BstNode(tree[0], tree[0].left, tree[0].right));

			// Node node = new Node(0,-1,-1);

			while (!queue.isEmpty()) {
				BstNode bst = queue.poll();
				if (bst == null)
					break;
				// if(b.n.val <= b.left || b.n.val >=b.right){
				if (bst.left != -1) {
					if (bst.node.key <= bst.left) {
						return false;
					} else {
						// queue.offer(new BNode(b.n.left, b.left, b.n.val));
						// queue.add(new BstNode(tree[bst.node.left], bst.left,
						// bst.node.key));
					}
				}
				if (bst.right != -1) {
					if (bst.node.key >= bst.right) {
						return false;
					} else {
						// queue.offer(new BNode(b.n.right, b.n.val, b.right));
						 queue.add(new BstNode(tree[bst.node.right], bst.node.key, bst.right ));
						// bst.node.key, bst.right));
					}
				}

			}

			// Implement correct algorithm here
			return true;
		}

		private Node getTree(int index){
			if(index != -1){
				return tree[index];
			}
				
			return null;
		}
		
		class BstNode {
			Node node;
			int left;
			int right;
			public BstNode(Node node, int left, int right) {				
				this.node = node;
				this.left = left;
				this.right = right;
			}
			
		}

		public class TreeNode {
			int key;
			TreeNode right;
			TreeNode left;

			public TreeNode() {

			}

			public TreeNode(int key, TreeNode right, TreeNode left) {

				this.right = right;
				this.key = key;

				this.left = left;
			}

		}

	}

	static public void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					new is_bst().run();
				} catch (IOException e) {
				}
			}
		}, "1", 1 << 26).start();
	}

	public void run() throws IOException {
		IsBST tree = new IsBST();
		tree.read();
		if (tree.isBinarySearchTree()) {
			System.out.println("CORRECT");
		} else {
			System.out.println("INCORRECT");
		}
	}
}
