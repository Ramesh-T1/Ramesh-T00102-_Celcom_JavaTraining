package com.Assignment2;

import java.util.ArrayList;

class Book {
	String title, author;
	int isbn;

	Book(String title, String author, int isbn) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", isbn=" + isbn + "]";
	}
	
}

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Book> a = new ArrayList<>();
		a.add(new Book("MyJourney", "APJ Abdul Kalam", 234));
		a.add(new Book("My Experiments with truth", "Mahatma Gandhi", 544));
		a.add(new Book("Playing it My Way", "Peter", 324));
		System.out.println("Total no.of Books added : ");
		//System.out.println(a);
		for(Book b:a) {
			System.out.println("Title = "+b.title+" ,Author = "+b.author+" ,ISBN = "+b.isbn);
		}
		a.remove(1);
		System.out.println("Total no.of Books after removing : ");
		//System.out.println(a);
		for(Book b:a) {
			System.out.println("Title = "+b.title+" ,Author = "+b.author+" ,ISBN = "+b.isbn);
		}
	}

}
