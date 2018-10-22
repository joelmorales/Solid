package com.assign2.jobqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.assign2.jobqueue.JobQueue.Heap;

public class TestPriority {

	static class minHeapComparatorClass implements Comparator<Heap> {
		public int compare(Heap x, Heap y) {
			return (int) (x.duration - y.duration); // reverse order
		}
	}

	public static void main(String[] args) {
		normalCase();
	}

	
	public static void normalCase() {
		//maxHeight = Math.max(maxHeight, height);
		// Duration = 1,2,3,4,5
		int duration = 1;
		int priority = 1;
		int threadIndex = 0;
		// We have 2 threads
		PriorityQueue<Heap> pQueue = new PriorityQueue<Heap>(2, new minHeapComparatorClass());
		// i=0
		pQueue.add(new Heap(duration, threadIndex,priority));
		
		// i=1
		duration = 2;
		priority = 1;
		threadIndex = 1;
		pQueue.add(new Heap(duration, threadIndex, priority));
		
		//find de min 		
		Heap heap = pQueue.poll();
		
		//El intent;o es que valla a lo ultimo
		priority=2;//size
		duration=10;
		pQueue.add(new Heap(duration, heap.index,priority));
		
		
		System.out.println("demo");
	}
	
	
	public static class Heap {
		private int duration;
		private int index;
		private int priority;
		
		public Heap(int duration, int index, int priority) {			
			this.duration = duration;
			this.index = index;
			this.priority = priority;
		}
		
		

	}

	
	
	
	
	

}
