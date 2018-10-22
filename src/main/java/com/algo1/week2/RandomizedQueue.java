package com.algo1.week2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {

	private Item[] items;
	private int N;

	@SuppressWarnings("unchecked")
	public RandomizedQueue() {
		this.N = 0;
		this.items = (Item[]) new Object[1];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	// add the item
	public void enqueue(Item item) {
		if (item == null) {
			throw new NullPointerException();
		}
		if (items.length == N) {
			resizing(2 * items.length);
		}
		items[N++] = item;
	}

	private void resizing(int capacity) {
		Item[] copy = ((Item[]) new Object[capacity]);
		for (int i = 0; i < N; i++)
			copy[i] = items[i];

		items = copy;
	}

	// delete and return a random item
	public Item dequeue() {
		if (N == 0) {
			throw new NoSuchElementException();
		}
		// int random = StdRandom.uniform(N);
		Random rand = new Random();
		int random = rand.nextInt(N);
		Item item = items[random];

		items[random] = items[--N];
		items[N] = null;

		if (N > 0 && N == items.length / 4) {
			resizing(items.length / 2);
		}
		return item;
	}

	// return (but do not delete) a random item
	public Item sample() {
		if (N == 0) {
			throw new NoSuchElementException();
		}
		// int random = StdRandom.uniform(N);
		Random rand = new Random();
		int random = rand.nextInt(N);
		return items[random];
	}

	@Override
	public Iterator<Item> iterator() {
		return new RandomizedQueueIterator();
	}

	private class RandomizedQueueIterator implements Iterator<Item> {

		private int current;
		private Item[] output;

		public RandomizedQueueIterator() {
			current=0;
			output = (Item[]) new Object[N];
			for (int i = 0; i < N; i++) {
				output[i] = items[i];
			}
			// StdRandom.shuffle(output);
			Collections.shuffle(Arrays.asList(output));
		}

		@Override
		public boolean hasNext() {
			return current < N;
		}

		@Override
		public Item next() {
			return output[current++];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	public static void main(String[] args) {
		RandomizedQueue<String> queue = new RandomizedQueue<String>();
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		queue.enqueue("D");
		queue.enqueue("E");
		queue.enqueue("F");

		/*System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());*/

		Iterator it1 = queue.iterator();
		Iterator it2 = queue.iterator();

		while (it1.hasNext()) {
			System.out.print(it1.next());
		}
		System.out.println("\n");
		while (it2.hasNext()) {
			System.out.print(it2.next());
		}
	}

}
