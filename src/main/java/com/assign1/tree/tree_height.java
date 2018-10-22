package com.assign1.tree;

import java.util.*;

import com.assign1.tree.tree_height.Nodes;

import java.io.*;

public class tree_height {
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

	public class Nodes {
		ArrayList<Nodes> childs = new ArrayList<Nodes>(2);
		private int value;

		public Nodes() {

		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

	}

	public class TreeHeight {
		int n;
		int parent[];

		Nodes[] nodes;

		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();

			parent = new int[n];
			nodes = new Nodes[n];

			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
				nodes[i] = new Nodes();
			}
		}

		int computeHeight() {

			int parent_index = 0;
			int parentValue = 0;
			int childValue = 0;
			for (int child_index = 0; child_index < n ; child_index++) {

				childValue = parent[child_index];
				if (childValue != -1) {
					parent_index = childValue;
					parentValue = parent[parent_index];
					nodes[parent_index].setValue(parentValue);
					nodes[child_index].setValue(childValue);
					
					nodes[parent_index].childs.add(nodes[child_index]);
				}

			}

			// Replace this code with a faster implementation
			int maxHeight = 0;
			System.out.println("Parent:" + parent[0] + " " + parent[n - 1]);
			for (int vertex = 0; vertex < n; vertex++) {
				int height = 0;
				// System.out.println("vertex:"+vertex);
				for (int i = vertex; i != -1; i = parent[i]) {
					System.out.println("          i=" + i + " parent[i] " + parent[i]);
					height++;
				}
				System.out.println("vertex:" + vertex + " height:" + height);
				maxHeight = Math.max(maxHeight, height);
			}
			return maxHeight;
		}
	}

	static public void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					new tree_height().run();
				} catch (IOException e) {
				}
			}
		}, "1", 1 << 26).start();
	}

	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
