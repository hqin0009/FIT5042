package fit5042.controllers;

import javax.el.ELContext;
import javax.inject.Named;

import fit5042.repository.entities.Customer;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import fit5042.repository.entities.Contact;
@Named(value = "customerController")
@RequestScoped
public class CustomerController {
	 private int customerId; 

	    public int getCustomerId() {
	        return customerId;
	    }

	    public void setCustomerId(int customerId) {
	        this.customerId = customerId;
	    }
	    private Customer customer;
	    
	    private Contact contact;
	    
	    private int contactId;
	    

	    public int getContactId() {
			return contactId;
		}

		public void setContactId(int contactId) {
			this.contactId = contactId;
		}

		public CustomerController() {

			  if(FacesContext.getCurrentInstance()
		                .getExternalContext()
		                .getRequestParameterMap()
		                .keySet().contains("customerID")) {
					        customerId = Integer.valueOf(FacesContext.getCurrentInstance()
					                .getExternalContext()
					                .getRequestParameterMap()
					                .get("customerID"));
					     
					        customer = getCustomer();
			  }
	        
	        if(FacesContext.getCurrentInstance()
	                .getExternalContext()
	                .getRequestParameterMap()
	                .keySet().contains("contactID")) {
	        	contactId = Integer.valueOf(FacesContext.getCurrentInstance()
		                .getExternalContext()
		                .getRequestParameterMap().get("contactID"));
	        	
	        	contact =  getContact();
	        	
	        }
	    }

	    public Customer getCustomer() {
	        if (customer == null) {
	           
	            ELContext context
	                    = FacesContext.getCurrentInstance().getELContext();
	            
	            CustomerApplication app
	                    = (CustomerApplication) FacesContext.getCurrentInstance()
	                            .getApplication()
	                            .getELResolver()
	                            .getValue(context, null, "customerApplication");
	            
	            return app.getCustomers().get(--customerId); 
	        }
	        return customer;
	    }
	   
	    public Contact getContact() {
	    	if(contact == null) {
	    		if(customer != null && customer.getContactList().size()>0) {
	    			for(Contact contactItem:customer.getContactList()) {
	    				if(contactItem.getContactId() == contactId) {
	    					contact = contactItem;
	    				}
	    			}
	    		}
	    	}
	    	
	    	return contact;
	    	
	    }
	    
	    
}
