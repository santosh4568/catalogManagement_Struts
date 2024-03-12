package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class book {
	private String book_name;
	@Id
	private int book_id;
	private String book_publisher;
	private float book_price;
	private String book_author;
	public book(String book_name, int book_id, String book_publisher, float book_price, String book_author) {
		super();
		this.book_name = book_name;
		this.book_id = book_id;
		this.book_publisher = book_publisher;
		this.book_price = book_price;
		this.book_author = book_author;
	}
	
	
	public book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_publisher() {
		return book_publisher;
	}
	public void setBook_publisher(String book_publisher) {
		this.book_publisher = book_publisher;
	}
	public float getBook_price() {
		return book_price;
	}
	public void setBook_price(float book_price) {
		this.book_price = book_price;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
}
