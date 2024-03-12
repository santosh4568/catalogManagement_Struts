package action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import helper.FactoryProvider;
import model.book;

public class Update extends ActionSupport{
	private String book_name;
	private int book_id;
	private String book_publisher;
	private float book_price;
	private String book_author;
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
	
	public String updateBook() {
		Session session = FactoryProvider.getFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			book bkBook = session.get(book.class, book_id);
			if(bkBook!=null) {
				bkBook.setBook_author(book_author);
				bkBook.setBook_id(book_id);
				bkBook.setBook_name(book_name);
				bkBook.setBook_price(book_price);
				bkBook.setBook_publisher(book_publisher);
				
				session.merge(bkBook);
				tx.commit();
				addActionMessage("Book is updated");
				return SUCCESS;
			}
			else {
				addActionMessage("Book id : "+ book_id +" not found.");
				return ERROR;
			}
		} catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            addActionError("Error updating book: " + e.getMessage());
            return ERROR;
        } finally {
            session.close();
        }
	}
}
