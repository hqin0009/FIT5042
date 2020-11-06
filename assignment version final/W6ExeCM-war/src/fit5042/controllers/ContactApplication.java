package fit5042.controllers;




import java.util.ArrayList;

import javax.el.ELContext;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.mBeans.CustomerManagedBean;
import fit5042.repository.entities.Contact;
import fit5042.repository.entities.Customer;

@Named(value = "contactApplication")
@ApplicationScoped

public class ContactApplication {
	@ManagedProperty(value="#{customerManagedBean}") 
	CustomerManagedBean customerManagedBean;
	
	 private ArrayList<Contact> contacts;

	    private boolean showForm = true;
	  
	    public boolean isShowForm() {
	        return showForm;
	    }
	    public ContactApplication() throws Exception {       
	    	contacts = new ArrayList<>();
	        
	       
	        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
	        customerManagedBean = (CustomerManagedBean) FacesContext.getCurrentInstance().getApplication()
	        .getELResolver().getValue(elContext, null, "customerManagedBean");
	        
	      
	        updateContactList();
	    }
	    
	    public ArrayList<Contact> getContacts() {
	        return contacts;
	    }
	    private void setContacts(ArrayList<Contact> newContacts) {
	        this.contacts = newContacts;
	    }
	    public void updateContactList()
	    {
	        if (contacts != null && contacts.size() > 0)
	        {
	            
	        }
	        else
	        {
	        	contacts.clear();

	            for (Contact contact : customerManagedBean.getAllContacts())
	            {
	            	contacts.add(contact);
	            }

	            setContacts(contacts);
	        }
	    }
	    public void searchContactById(int contactId)
	    {
	    	contacts.clear();
	        
	    	contacts.add(customerManagedBean.searchContactById(contactId));
	    }
	    public void searchContactByContactName(String contactName) 
	    {
	    	contacts.clear();
	        
	    	contacts.addAll(customerManagedBean.searchContactByName(contactName));
	    }
	    
	    public void searchAll()
	    {
	    	contacts.clear();
	        
	        for (Contact contact : customerManagedBean.getAllContacts())
	        {
	        	contacts.add(contact);
	        }
	        
	        setContacts(contacts);
	    }
}
