package com.assign2.jobqueue;

import java.io.BufferedOutputStream;
import java.io.*;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JobQueue {
	private int numWorkers;
	private long[] jobs;

	//private long[] assignedWorker;
	//private long[] startTime;

	private long[] assignedWorkerTemp;
	private long[] startTimeTemp;

	private FastScanner in;
	private PrintWriter out;

	PriorityQueue<Long> pQueue = new PriorityQueue<Long>();

	public static void main(String[] args) throws IOException {
		new JobQueue().solve();
	}

	private void readData() throws IOException {
		numWorkers = (int) in.nextLong();
		long m = in.nextLong();
		jobs = new long[(int) m];
		for (int i = 0; i < m; ++i) {
			jobs[i] = in.nextLong();
		}
	}

	private void writeResponse() {
		for (int i = 0; i < jobs.length; ++i) {
			out.println(assignedWorkerTemp[i] + " " + startTimeTemp[i]);
		}
	}

	static class minHeapComparator implements Comparator<Integer> {
		public int compare(Integer x, Integer y) {
			return x - y; // reverse order
		}
	}

	static class minHeapComparatorClass implements Comparator<Heap> {
		public int compare(Heap x, Heap y) {
			/*
			 * if (x.duration == y.duration && (x.applyInverse==true ||
			 * y.applyInverse==true) ) { return (int) (y.index - x.index ); }
			 * else return (int) (x.duration - y.duration);
			 */

			if (x.duration == y.duration) {
				return (int) (x.priority - y.priority);
			}

			return (int) (x.duration - y.duration);
		}
	}

	public class Heap {
		private long duration;
		private int index;
		private int priority;

		public Heap(long duration, int index, int priority) {

			this.duration = duration;
			this.index = index;
			this.priority = priority;
		}
	}

	private void assignJobs() {

		/*
		 * long[] assignedWorkerTemp; long[] startTimeTemp;
		 */

		int maxPriority = 0;

		//assignedWorker = new long[jobs.length];
		//startTime = new long[jobs.length];

		assignedWorkerTemp = new long[jobs.length];
		startTimeTemp = new long[jobs.length];

		PriorityQueue<Heap> pQueue = new PriorityQueue<Heap>(numWorkers, new minHeapComparatorClass());
		//PriorityQueue<Heap> pQueue = new PriorityQueue<Heap>(numWorkers/jobs.length, new minHeapComparatorClass());
		
		//long[] nextFreeTime = new long[numWorkers];
		long[] nextFreeTimeTemp = new long[numWorkers];
		for (int i = 0; i < jobs.length; i++) {
			long duration = jobs[i];
			//int bestWorker = 0;

			maxPriority += 1;

			if (i < numWorkers) {
				// Esto es cuando estan todos vacios, por eso uso este contador
				// para inicializar
				pQueue.add(new Heap(duration, i, maxPriority));
				assignedWorkerTemp[i] = i; // contador de los workers
				startTimeTemp[i] = 0;
				nextFreeTimeTemp[i] += duration;
			} else {
				// Buscar el minimo
				Heap heap = pQueue.poll();
				assignedWorkerTemp[i] = heap.index;
				startTimeTemp[i] = nextFreeTimeTemp[heap.index];
				nextFreeTimeTemp[heap.index] += duration;
				pQueue.add(new Heap(duration, heap.index, maxPriority));
			}

			/*
			 * for (int j = 0; j < numWorkers; ++j) { if (nextFreeTime[j] <
			 * nextFreeTime[bestWorker]) bestWorker = j; }
			 * 
			 * assignedWorker[i] = bestWorker; startTime[i] =
			 * nextFreeTime[bestWorker]; nextFreeTime[bestWorker] += duration;
			 */
		}

		/*
		 * while (pQueue.size() != 0) {
		 * System.out.println(pQueue.poll().duration); }
		 */

	}

	public void solve() throws IOException {
		in = new FastScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		readData();
		assignJobs();
		writeResponse();
		out.close();
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
		
		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}
		
	}
}
