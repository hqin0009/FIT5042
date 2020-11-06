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
@Named("removeContact")
public class RemoveContact {
	@ManagedProperty(value = "#{customerManagedBean}")
	CustomerManagedBean customerManagedBean;

	private boolean showForm = true;
	ContactApplication app;

	public boolean isShowForm() {
		return showForm;
	}

	public RemoveContact() {
		ELContext context = FacesContext.getCurrentInstance().getELContext();

		app = (ContactApplication) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(context,
				null, "contactApplication");

		app.updateContactList();

		
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		customerManagedBean = (CustomerManagedBean) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(elContext, null, "customerManagedBean");
	}

	/**
	 * @param customer Id
	 */
	public void removeContact(int contactId) {
		try {
			
			customerManagedBean.removeContact(contactId);

			
			app.searchAll();
			
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Customer has been deleted succesfully"));
		} catch (Exception ex) {

		}
		showForm = true;

	}

}
