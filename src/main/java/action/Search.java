package action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import helper.FactoryProvider;
import model.book;

public class Search extends ActionSupport{
	private int book_id;

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String searchBook() {
		Session session = FactoryProvider.getFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			book bkBook = session.get(book.class, book_id);
			if(bkBook!=null) {
				tx.commit();
				return SUCCESS;
			}
			else {
				return ERROR;
			}
		} catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            addActionError("Error Search book: " + e.getMessage());
            return ERROR;
        } finally {
            session.close();
        }
	}
}
