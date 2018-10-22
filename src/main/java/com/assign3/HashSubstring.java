package com.assign3;


import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HashSubstring {

	private static FastScanner in;
	private static PrintWriter out;
	private static int prime = 100007;
	private static int multiplier = 263;
	//private static long RM;
	//private static long[] stringHash;
	
	public static void main(String[] args) throws IOException {
		in = new FastScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		printOccurrences(getOccurrences(readInput()));
		out.close();
	}

	private static Data readInput() throws IOException {
		String pattern = in.next();
		String text = in.next();
		return new Data(pattern, text);
	}

	private static long polyhash(String s) {
		long hash = 0;
		for (int i = 0; i < s.length(); i++)
			hash = ((hash * multiplier + s.charAt(i))) % prime;
		return hash ;
	}
	
	private static long[] preComputeHashes(String pattern, String txt){
		long RM = 1;
		int M=pattern.length();
		int n = txt.length();
		long[] sHash=new long[n-M+1];
		
		sHash[0] = polyhash(txt.substring(0, M));
		for (int i = 1; i<= M-1; i++)
			RM = (multiplier * RM) % prime;
		
		long txtHash = sHash[0];
		int hCount=1;
		for(int i=M ; i < n; i++){
			//1
			//txtHash = (txtHash + Q - RM * txt.charAt(i - M) % Q) % Q; 
            //txtHash = (txtHash * R + txt.charAt(i)) % Q; 
			
			txtHash = ( txtHash + prime - RM * txt.charAt(i - M) % prime ) % prime;
			txtHash = (txtHash * multiplier + txt.charAt(i) ) % prime;
			sHash[hCount] = txtHash;
			hCount++;
		}
		return sHash;
	}
	
	private static void printOccurrences(List<Integer> ans) throws IOException {
		for (Integer cur : ans) {
			out.print(cur);
			out.print(" ");
		}
	}

	private static boolean AreEqual(String pattern, String substring) {
		if(pattern.equals(substring))
			return true;
		else return false;
	}
	
	private static List<Integer> getOccurrences(Data input) {
		String pattern = input.pattern, txt = input.text;
		int m = pattern.length(), n = txt.length();
		long[] stringHash = new long[n-m+1];
		
		stringHash=preComputeHashes(pattern,txt);
		
		//
		List<Integer> occurrencesNew = new ArrayList<Integer>();
		long pHash = polyhash(pattern);
		for (int i = 0; i + m <= n; ++i) {
			//String substring= txt.substring(i, m+i);
			//long tHash = polyhash(substring);
			
			if(pHash != stringHash[i])
				continue;
			if(AreEqual(pattern,txt.substring(i, m+i))) {
				occurrencesNew.add(i);
			}
		}
		//
		
		/*List<Integer> occurrences = new ArrayList<Integer>();
		for (int i = 0; i + m <= n; ++i) {
			boolean equal = true;
			for (int j = 0; j < m; ++j) {
				if (pattern.charAt(j) != t.charAt(i + j)) {
					equal = false;
					break;
				}
			}
			if (equal)
				occurrences.add(i);
		}
		return occurrences;*/
		
		return occurrencesNew;
	}

	static class Data {
		String pattern;
		String text;

		public Data(String pattern, String text) {
			this.pattern = pattern;
			this.text = text;
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

		/*public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}*/
	}
}
