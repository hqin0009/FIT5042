package fit5042.controllers;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.repository.entities.Contact;
import fit5042.repository.entities.Customer;

@RequestScoped
@Named("searchContact")
public class SearchContact {
	private Contact contact;

	ContactApplication app;

	private int searchByInt;
	private String searchByContactName;
	
	public ContactApplication getApp() {
		return app;
	}

	public void setApp(ContactApplication app) {
		this.app = app;
	}
	
	public int getSearchByInt() {
		return searchByInt;
	}

	public void setSearchByInt(int searchByInt) {
		this.searchByInt = searchByInt;
	}
	
	public String getSearchByContactName() {
		return searchByContactName;
	}

	public void setSearchByContactName(String searchByContactName) {
		this.searchByContactName = searchByContactName;
	}
	
	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Contact getContact() {
		return contact;
	}
	
	public SearchContact() {
		ELContext context = FacesContext.getCurrentInstance().getELContext();

		app = (ContactApplication) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(context,
				null, "contactApplication");

		app.updateContactList();
	}
	
	public void searchContactById(int contactId) {
		try {
			
			app.searchContactById(contactId);
		} catch (Exception ex) {

		}
	}
	
	public void searchByContactName(String contactName) {
		try {
			
			app.searchContactByContactName(contactName);
		} catch (Exception ex) {

		}
	}
	

	public void searchAll() {
		try {
			
			app.searchAll();
		} catch (Exception ex) {

		}
	}
}
