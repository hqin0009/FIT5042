package fit5042.controllers;

import javax.el.ELContext;
import javax.inject.Named;

import fit5042.repository.entities.Customer;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import fit5042.repository.entities.Contact;
@Named(value = "contactController")
@RequestScoped
public class ContactController {

	    
	    private Contact contact;
	    
	    private int contactId;
	    

	    public int getContactId() {
			return contactId;
		}

		public void setContactId(int contactId) {
			this.contactId = contactId;
		}

		public ContactController() {

			if(FacesContext.getCurrentInstance()
	                .getExternalContext()
	                .getRequestParameterMap()
	                .keySet().contains("contactID")) {
		        contactId = Integer.valueOf(FacesContext.getCurrentInstance()
		                .getExternalContext()
		                .getRequestParameterMap()
		                .get("contactID"));
		     
		        contact = getContact();
			}
	       
	        	
	        
	    }


	    public Contact getContact() {
	    	 if (contact == null) {
	        
	             ELContext context
	                     = FacesContext.getCurrentInstance().getELContext();
	             ContactApplication app
	                     = (ContactApplication) FacesContext.getCurrentInstance()
	                             .getApplication()
	                             .getELResolver()
	                             .getValue(context, null, "contactApplication");
	             
	             return app.getContacts().get(--contactId); 
	         }
	         return contact;
	    	
	    }
	    
	    
}
