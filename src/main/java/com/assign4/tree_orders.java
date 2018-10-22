package com.assign4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;



public class tree_orders {
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

	public class TreeNode {
		private int key;
		private TreeNode right;
		private TreeNode left;

		public TreeNode() {
		}

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public TreeNode getRight() {
			return right;
		}

		public void setRight(TreeNode right) {
			this.right = right;
		}

		public TreeNode getLeft() {
			return left;
		}

		public void setLeft(TreeNode left) {
			this.left = left;
		}

	}

	public class TreeOrders {
		int n;
		int[] key, left, right;

		TreeNode[] nodes;
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			key = new int[n];
			left = new int[n];
			right = new int[n];
			nodes =  new TreeNode[n];			
			
			for (int i = 0; i < n; i++) {
				key[i] = in.nextInt();
				left[i] = in.nextInt();
				right[i] = in.nextInt();
				
				if(nodes[i]==null) {
					nodes[i]= new TreeNode();
				}				
				nodes[i].key = key[i];
				if(left[i]!=-1) {
					if(nodes[left[i]]==null) {
						nodes[left[i]] = new TreeNode();
					}
					nodes[i].left = nodes[left[i]];
				}
				if(right[i] !=-1) {
					if(nodes[right[i]] ==null) {
						nodes[right[i]]=new TreeNode();
					}
					nodes[i].right = nodes[right[i]];
				}
			}
			
			
			
		}

		List<Integer> inOrder() {			
			ArrayList<Integer> result = new ArrayList<Integer>();		
			inOrderTraversal(nodes[0],result);
			return result;
		}

		void inOrderTraversal(TreeNode tree,ArrayList<Integer> result) {
			if (tree==null){
				return ;
			}
			inOrderTraversal(tree.left,result);
			result.add(tree.key);
			inOrderTraversal(tree.right,result);
		}
		
		
		List<Integer> preOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			// Finish the implementation
			// You may need to add a new recursive method to do that
			preOrderTraversal(nodes[0],result);
			return result;
		}

		void preOrderTraversal(TreeNode tree,ArrayList<Integer> result) {
			if (tree==null){
				return ;
			}
			result.add(tree.key);
			preOrderTraversal(tree.left,result);			
			preOrderTraversal(tree.right,result);
		}
		
		List<Integer> postOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			// Finish the implementation
			// You may need to add a new recursive method to do that
			postOrderTraversal(nodes[0],result);
			return result;
		}
		
		void postOrderTraversal(TreeNode tree,ArrayList<Integer> result) {
			if (tree==null){
				return ;
			}			
			postOrderTraversal(tree.left,result);			
			postOrderTraversal(tree.right,result);
			result.add(tree.key);
		}
	}

	static public void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					new tree_orders().run();
				} catch (IOException e) {
				}
			}
		}, "1", 1 << 26).start();
	}

	public void print(List<Integer> x) {
		for (Integer a : x) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public void run() throws IOException {
		TreeOrders tree = new TreeOrders();
		tree.read();
		print(tree.inOrder());
		print(tree.preOrder());
		print(tree.postOrder());
	}
}
