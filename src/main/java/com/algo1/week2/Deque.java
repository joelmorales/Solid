package com.algo1.week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

//import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item> {

	private Node first ;
	private Node last ;
	private int N ;
	
	private class Node {
		Item item;
		Node next;
		Node prev;
	}

	public Deque() {
		first = null;
		last = null;
		N = 0;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void addFirst(Item item) {
		if (item == null) {
			throw new IllegalArgumentException();
		}

		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		if (N == 0) {
			last = first;
		} else {
			oldFirst.prev = first;
		}
		N++;
	}

	// enqueue insert into the queue
	public void addLast(Item item) {
		if (item == null) {
			throw new IllegalArgumentException();
		}
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.prev = oldlast;

		if (N == 0) {
			first = last;
		} else {
			oldlast.next = last;
		}
		N++;
	}

	// dequeue remove at the end
	public Item removeFirst() {
		if (N == 0) {
			throw new NoSuchElementException();
		}

		Item item = first.item;
		first = first.next;
		N--;
		if (N == 0) {
			last = first;
		} else {
			first.prev = null;
		}
		return item;
	}

	public Item removeLast() {
		if (N == 0) {
			throw new NoSuchElementException();
		}

		Item item = last.item;
		last = last.prev;
		N--;
		if (N == 0) {
			first = last;
		} else {
			last.next = null;
		}
		return item;
	}

	public Iterator<Item> iterator() {
		return new DequeListIterator();
	}

	private class DequeListIterator implements Iterator<Item> {

		private Node current ;

		private DequeListIterator(){
			current=first;
		}
		
		public boolean hasNext() {
			return current != null;
		}

		public Item next() {
			if (!hasNext())
				throw new java.util.NoSuchElementException();

			Item item = current.item;
			current = current.next;
			return item;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public static void main(String[] args) {

		Deque<String> deck = new Deque<String>();
		System.out.println(deck.isEmpty());
		System.out.println(deck.size());

		deck.addLast("This");
		deck.addLast("Is a");
		deck.addLast("Profesional");
		deck.addLast("Test Code");
		deck.addFirst("First Part");

		System.out.println(deck.size());
		//StdOut.println(deck.removeFirst());
		// StdOut.println(deck.removeFirst());
		// StdOut.println(deck.removeFirst());
		//StdOut.println(deck.removeLast());
		//StdOut.println(deck.removeLast());

		Iterator<String> it = deck.iterator();
		
		System.out.println(it.next());
		System.out.println(it.hasNext());
		
	}

}
