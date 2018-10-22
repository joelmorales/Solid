package com.assign3;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.StringTokenizer;

public class HashChains {

	private FastScanner in;
	private PrintWriter out;
	// store all strings in one list
	private List<String> elems;
	// for hash function
	private int bucketCount;
	private int prime = 1000000007;
	private int multiplier = 263;
	//
	private Hashtable<Integer, ArrayList<String>> stringChains;

	public static void main(String[] args) throws IOException {
		new HashChains().processQueries();
	}

	private int hashFunc(String s) {
		long hash = 0;
		for (int i = s.length() - 1; i >= 0; --i)
			hash = (hash * multiplier + s.charAt(i)) % prime;
		return (int) hash % bucketCount;
	}

	private Query readQuery() throws IOException {
		String type = in.next();
		if (!type.equals("check")) {
			String s = in.next();
			return new Query(type, s);
		} else {
			int ind = in.nextInt();
			return new Query(type, ind);
		}
	}

	private void writeSearchResult(boolean wasFound) {
		out.println(wasFound ? "yes" : "no");
		// Uncomment the following if you want to play with the program
		// interactively.
		// out.flush();
	}

	private void writeSearchResultNew(boolean wasFound) {
		out.println(wasFound ? "yes" : "no");
		// Uncomment the following if you want to play with the program
		// interactively.
		// out.flush();
	}

	private ArrayList<String> setNewStack(String s) {
		ArrayList<String> stack = new ArrayList<String>();
		stack.add(s);
		return stack;
	}

	private void processQueryNew(Query query) {
		Integer hashKey;
		switch (query.type) {
		case "add":
			hashKey = hashFunc(query.s);
			if (stringChains.get(hashKey) != null) {
				ArrayList<String> list = stringChains.get(hashKey);
				if(!list.contains(query.s)){
					list.add(query.s);
					stringChains.put(hashKey, list);
				}
			} else {
				stringChains.put(hashKey, setNewStack(query.s));
			}
			break;
		case "del":
			hashKey = hashFunc(query.s);
			if (stringChains.get(hashKey) != null) {
				ArrayList<String> list = stringChains.get(hashKey);
				if (list.size() > 1) {
					list.remove(query.s);
					stringChains.put(hashKey, list);
				} else {
					stringChains.remove(hashKey);
				}
			}
			break;
		case "find":
			hashKey = hashFunc(query.s);
			if (stringChains.get(hashKey) != null) {
				ArrayList<String> list = stringChains.get(hashKey);
				writeSearchResultNew(list.contains(query.s));
			}else{
				writeSearchResultNew(false);
			}
			break;
		case "check":
			if (!stringChains.isEmpty()) {
				ArrayList<String> list = stringChains.get(query.ind);
				if (list != null && list.size() > 0) {
					Collections.reverse(list);
					list.forEach(s -> out.print(s + " "));
				}
			}
			out.println();
			break;
		default:
			// throw new RuntimeException("Unknown query: " + query.type);
		}
	}

	private void processQuery(Query query) {
		//processQueryNew(query);

		switch (query.type) {
		case "add":
			if (!elems.contains(query.s))
				elems.add(0, query.s);
			break;
		case "del":
			if (elems.contains(query.s))
				elems.remove(query.s);
			break;
		case "find":
			writeSearchResult(elems.contains(query.s));
			break;
		case "check":
			for (String cur : elems)
				if (hashFunc(cur) == query.ind)
					out.print(cur + " ");
			out.println();
			// Uncomment the following if you want to play with the program
			// interactively.
			// out.flush();
			break;
		default:
			throw new RuntimeException("Unknown query: " + query.type);
		}
	}

	public void processQueries() throws IOException {
		elems = new ArrayList<>();
		in = new FastScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		bucketCount = in.nextInt();
		stringChains = new Hashtable<Integer, ArrayList<String>>(bucketCount);
		int queryCount = in.nextInt();
		for (int i = 0; i < queryCount; ++i) {
			processQueryNew(readQuery());
		}
		out.close();
	}

	static class Query {
		String type;
		String s;
		int ind;

		public Query(String type, String s) {
			this.type = type;
			this.s = s;
		}

		public Query(String type, int ind) {
			this.type = type;
			this.ind = ind;
		}
	}

	static class FastScanner {
		private BufferedReader reader;
		private StringTokenizer tokenizer;

		public FastScanner() {
			reader = new BufferedReader(new InputStreamReader(System.in));
			tokenizer = null;
		}

		public String next() throws IOException {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}
}
