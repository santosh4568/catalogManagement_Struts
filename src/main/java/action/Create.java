package action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import helper.FactoryProvider;
import model.book;

public class Create extends ActionSupport{
	book new_book = new book();

	public book getNew_book() {
		return new_book;
	}

	public void setNew_book(book new_book) {
		this.new_book = new_book;
	}
	public String addBook() {
		Session session = FactoryProvider.getFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(new_book);
			tx.commit();
			addActionMessage("Book is added");
			return SUCCESS;
		} 
		catch (Exception e) {
			// Rollback the transaction in case of an exception
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			// Handle any exceptions that occur during the employee creation process
			addActionError("Error inserting book: " + e.getMessage());
			return ERROR;
		} finally {
			session.close();
		}
		
	}
}
