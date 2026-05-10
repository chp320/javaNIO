package com.study.java.ch06;

import java.io.Serializable;

public class Book implements Serializable {
	// 클래스 필드
	private String isbn;
	private String title;
	transient private String author;
	private int price;
	
	public Book(String isbn, String title, String author, int price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", isbn=" + isbn + ", price=" + price + ", title=" + title + "]";
	}
	
}
