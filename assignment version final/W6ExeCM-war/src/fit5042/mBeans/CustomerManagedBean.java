package fit5042.mBeans;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
//import javax.mail.Address;

import fit5042.repository.ContactRepository;
import fit5042.repository.CustomerRepository;
import fit5042.repository.entities.Contact;
import fit5042.repository.entities.Customer;

@ManagedBean(name = "customerManagedBean")
@SessionScoped

public class CustomerManagedBean implements Serializable {

    @EJB
    CustomerRepository customerRepository;
    
    @EJB
    ContactRepository contactRepository;

    /**
     * Creates a new instance of CustomerManagedBean
     */
    public CustomerManagedBean() {
    }

    public List<Customer> getAllCustomers() {
        try {
            List<Customer> properties = customerRepository.getAllCustomers();
            return properties;
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
    public List<Contact> getAllContacts() {
        try {
            List<Contact> properties = contactRepository.getAllContacts();
            return properties;
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
    
    public void addCustomer(Customer customer) 
    {
        try {
        	customer.setInsertDate(new Date(System.currentTimeMillis()));

        	customer.setUpdateDate(new Date(System.currentTimeMillis()));
             customerRepository.addCustomer(customer);
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void addContact(Contact contact) 
    {
        try {
        	contactRepository.addContact(contact);
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Search a customer by Id
     */
    public Customer searchCustomerById(int id)
    {
        try {
            return customerRepository.searchCustomerById(id);
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
    public Contact searchContactById(int id)
    {
        try {
            return contactRepository.searchContactById(id);
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
    
    
    /**
     * Search a customer by name
     */
    public List<Customer> searchCustomerByName(String customerName)
    {
        try {
            return customerRepository.searchCustomerByName(customerName);
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
    public List<Contact> searchContactByName(String contactName)
    {
        try {
            return contactRepository.searchContactByName(contactName);
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
    

    public void removeCustomer(int customerId) 
    {
        try {
            customerRepository.removeCustomer(customerId);
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void removeContact(int contactId) 
    {
        try {
        	contactRepository.removeContact(contactId);
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editCustomer(Customer customer)
    {
        try {
        	customer.setUpdateDate(new Date(System.currentTimeMillis()));
            customerRepository.editCustomer(customer);
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer has been updated succesfully"));
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void editContact(Contact contact)
    {
        try {
        	contact.setUpdateDate(new Date(System.currentTimeMillis()));
        	contactRepository.editContact(contact);
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contact has been updated succesfully"));
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


  
    public void addCustomer(fit5042.controllers.Customer localCustomer) {
        //convert this newProperty which is the local Customer to entity property
    	Customer customer = convertCustomerToEntity(localCustomer);

        try {
        	customer.setInsertDate(new Date(System.currentTimeMillis()));
        	customer.setUpdateDate(new Date(System.currentTimeMillis()));
        	customerRepository.addCustomer(customer);
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    private Customer convertCustomerToEntity(fit5042.controllers.Customer localCustomer) {
    	Customer customer = new Customer(); //entity
        customer.setCreatorId(localCustomer.getCreatorId());
        customer.setCustomerName(localCustomer.getCustomerName());
        customer.setCustomerAddress(localCustomer.getCustomerAddress());
        customer.setCustomerTypeId(localCustomer.getCustomerTypeId());
        customer.setCustomerPhone(localCustomer.getCustomerPhone());
        return customer;
    }
    
    
    public void addContact(fit5042.controllers.Contact localContact) {
        //convert this newProperty which is the local Customer to entity property
    	Contact contact = convertContactToEntity(localContact);
    	contact.setCustomer(new Customer());
    	contact.getCustomer().setCustomerId(localContact.getCustomerId());
    	contact.setInsertDate(new Date(System.currentTimeMillis()));
    	contact.setUpdateDate(new Date(System.currentTimeMillis()));
        try {
        	contactRepository.addContact(contact);
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    private Contact convertContactToEntity(fit5042.controllers.Contact localContact) {
    	Contact contact = new Contact(); //entity
    	contact.setCustomer(localContact.getCustomer());

    	contact.setContactAddress(localContact.getContactAddress());

    	contact.setContactName(localContact.getContactName());
    	
    	contact.setPhoneNumber(localContact.getPhoneNumber());
    	
    	contact.setInsertDate(new Date(System.currentTimeMillis()));

    	contact.setUpdateDate(new Date(System.currentTimeMillis()));
    	
    	
        return contact;
    }
  
   
   
}

