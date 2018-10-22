package com.assign3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class PhoneBook {

	private FastScanner in = new FastScanner();
	// Keep list of all existing (i.e. not deleted yet) contacts.
	private List<Contact> contacts = new ArrayList<>();

	private Hashtable<String, Integer> names = new Hashtable<String, Integer>(100000);
	private Hashtable<Integer, String> phones = new Hashtable<Integer, String>(100000);

	public static void main(String[] args) {
		new PhoneBook().processQueries();
	}

	private Query readQuery() {
		String type = in.next();
		int number = in.nextInt();
		if (type.equals("add")) {
			String name = in.next();
			return new Query(type, name, number);
		} else {
			return new Query(type, number);
		}
	}

	private void writeResponse(String response) {
		System.out.println(response);
	}
	

	private void processQueryNew(Query query) {
		if (query.type.equals("add")) {			
			if (phones.get(query.number) != null) {			
				String nameFound = phones.get(query.number).toString();
				names.remove(nameFound);
			}
			phones.put(query.number, query.name);
			names.put(query.name, query.number);
		} else if (query.type.equals("del")) {
			if (phones.get(query.number) != null){
				String nameFound = phones.get(query.number).toString();
				phones.remove(query.number);
				names.remove(nameFound);
			}
		}else{
			String response = "not found";
			String nameFound = phones.get(query.number);
			if(nameFound != null){
				response = nameFound;
			}
			writeResponse(response);
		}
	}

	private void processQuery(Query query) {		
		if (query.type.equals("add")) {
			// if we already have contact with such number,
			// we should rewrite contact's name
			boolean wasFound = false;
			for (Contact contact : contacts)
				if (contact.number == query.number) {
					contact.name = query.name;
					wasFound = true;
					break;
				}
			// otherwise, just add it
			if (!wasFound)
				contacts.add(new Contact(query.name, query.number));
		} else if (query.type.equals("del")) {
			for (Iterator<Contact> it = contacts.iterator(); it.hasNext();)
				if (it.next().number == query.number) {
					it.remove();
					break;
				}
		} else {
			String response = "not found";
			for (Contact contact : contacts)
				if (contact.number == query.number) {
					response = contact.name;
					break;
				}
			writeResponse(response);
		}
	}

	public void processQueries() {
		int queryCount = in.nextInt();
		for (int i = 0; i < queryCount; ++i)
			processQueryNew(readQuery());
	}

	static class Contact {
		String name;
		int number;

		public Contact(String name, int number) {
			this.name = name;
			this.number = number;
		}
	}

	static class Query {
		String type;
		String name;
		int number;

		public Query(String type, String name, int number) {
			this.type = type;
			this.name = name;
			this.number = number;
		}

		public Query(String type, int number) {
			this.type = type;
			this.number = number;
		}
	}

	class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
