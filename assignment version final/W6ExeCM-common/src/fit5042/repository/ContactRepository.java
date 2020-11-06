package fit5042.repository;

import java.util.List;

import fit5042.repository.entities.Contact;
import fit5042.repository.entities.Customer;

public interface ContactRepository {
	/**
     * Add the contact being passed as parameter into the repository
     *
     * @param contact - the contact to add
     */
    public void addContact(Contact contact) throws Exception;

    /**
     * Search for a contact by its contact ID
     *
     * @param id - the contactId of the contact to search for
     * @return the contact found
     */
    public Contact searchContactById(int id) throws Exception;

    /**
     * Return all the properties in the repository
     *
     * @return all the properties in the repository
     */
    public List<Contact> getAllContacts() throws Exception;
    

    
    /**
     * Remove the contact, whose contact ID matches the one being passed as parameter, from the repository
     *
     * @param contactId - the ID of the contact to remove
     */
    public void removeContact(int contactId) throws Exception;
    
    /**
     * Update a contact in the repository
     *
     * @param contact - the updated information regarding a contact
     */
    public void editContact(Contact contact) throws Exception;
    
    
    public List<Contact> getContactsByCutomerId(int customerId) throws Exception;
    
    public List<Contact> searchContactByName(String contactName) throws Exception;
}
