package fit5042.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.mBeans.CustomerManagedBean;
import fit5042.repository.entities.Customer;

@RequestScoped
@Named("addContact")
public class AddContact {
	@ManagedProperty(value = "#{customerManagedBean}")
	CustomerManagedBean customerManagedBean;

	private boolean showForm = true;

	private Contact contact;

	ContactApplication app;

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Contact getContact() {
		return contact;
	}

	public boolean isShowForm() {
		return showForm;
	}

	public AddContact() {
		ELContext context = FacesContext.getCurrentInstance().getELContext();

		app = (ContactApplication) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(context,
				null, "contactApplication");

	
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		customerManagedBean = (CustomerManagedBean) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(elContext, null, "customerManagedBean");
	}

	public void addContact(Contact localContact) {
	
		try {


			customerManagedBean.addContact(localContact);
			
		
			app.searchAll();
	

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contact has been added succesfully"));
	
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		showForm = true;
	}

}