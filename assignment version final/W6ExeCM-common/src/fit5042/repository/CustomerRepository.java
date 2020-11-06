package fit5042.repository;

import java.util.List;

import fit5042.repository.entities.Customer;

public interface CustomerRepository {
	/**
     * Add the customer being passed as parameter into the repository
     *
     * @param customer - the customer to add
     */
    public void addCustomer(Customer customer) throws Exception;

    /**
     * Search for a customer by its customer ID
     *
     * @param id - the customerId of the customer to search for
     * @return the customer found
     */
    public Customer searchCustomerById(int id) throws Exception;

    /**
     * Return all the properties in the repository
     *
     * @return all the properties in the repository
     */
    public List<Customer> getAllCustomers() throws Exception;
    

    
    /**
     * Remove the customer, whose customer ID matches the one being passed as parameter, from the repository
     *
     * @param customerId - the ID of the customer to remove
     */
    public void removeCustomer(int customerId) throws Exception;
    
    /**
     * Update a customer in the repository
     *
     * @param customer - the updated information regarding a customer
     */
    public void editCustomer(Customer customer) throws Exception;

    /**
     * Search for properties whose price is less than or equal to a budget
     *
     * @param budget - the budget that the price of the returned properties must be lower than or equal to
     * @return the properties found
     */
    public List<Customer> searchCustomerByName(String customerName) throws Exception;
    
    /**
     * Search for properties by their contact person
     *
     * @param contactPerson - the contact person that is responsible for the properties
     * @return the properties found
     */
    public List<Customer> searchCustomerByCreatorId(int creatorId) throws Exception;
}
