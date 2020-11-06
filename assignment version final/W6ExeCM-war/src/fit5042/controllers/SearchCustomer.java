package fit5042.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.repository.entities.Customer;

@RequestScoped
@Named("searchCustomer")
public class SearchCustomer {
	private Customer customer;

	CustomerApplication app;

	private int searchByInt;
	private String searchByCustomerName;

	public CustomerApplication getApp() {
		return app;
	}

	public void setApp(CustomerApplication app) {
		this.app = app;
	}




	public int getSearchByInt() {
		return searchByInt;
	}

	public void setSearchByInt(int searchByInt) {
		this.searchByInt = searchByInt;
	}

	


	public String getSearchByCustomerName() {
		return searchByCustomerName;
	}

	public void setSearchByCustomerName(String searchByCustomerName) {
		this.searchByCustomerName = searchByCustomerName;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public SearchCustomer() {
		ELContext context = FacesContext.getCurrentInstance().getELContext();

		app = (CustomerApplication) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(context,
				null, "customerApplication");

		app.updateCustomerList();
	}

	/**
	 * Normally each page should have a backing bean but you can actually do it any
	 * how you want.
	 *
	 * @param customer Id
	 */
	public void searchCustomerById(int customerId) {
		try {
			app.searchCustomerById(customerId);
		} catch (Exception ex) {

		}
	}
	
	public void searchByCustomerName(String customerName) {
		try {
			
			app.searchCustomerByCustomerName(customerName);
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
