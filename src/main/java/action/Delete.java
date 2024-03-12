package action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import helper.FactoryProvider;
import model.book;

public class Delete extends ActionSupport{
	private int book_id;

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String deleteBook() {
		Session session = FactoryProvider.getFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			book bk = session.get(book.class, book_id);
			
			if(bk!=null) {
				session.remove(bk);
				tx.commit();
				addActionMessage("Book is successfully Deleted");
				return SUCCESS;
			}
			else {
				addActionMessage("Book Not Found.");
				return ERROR;
			}
		} catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            addActionError("Error deleting book: " + e.getMessage());
            return ERROR;
        } finally {
            session.close();
        }
	}
}
