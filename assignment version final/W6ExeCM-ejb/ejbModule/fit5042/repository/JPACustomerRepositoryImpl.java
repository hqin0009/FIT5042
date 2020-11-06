package fit5042.repository;


import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import fit5042.repository.entities.Customer;

/**
 *
 * @author Eddie Leung
 */
@Stateless
public class JPACustomerRepositoryImpl implements CustomerRepository {

    @PersistenceContext(unitName = "W6ExeCM-ejb")
    private EntityManager entityManager;

    @Override
    public void addCustomer(Customer customer) throws Exception {
    	List<Customer> customers =  entityManager.createNamedQuery(Customer.GET_ALL_QUERY_NAME).getResultList(); 
        customer.setCustomerId(customers.get(0).getCustomerId() + 1);
        entityManager.persist(customer);
    }
     
    @Override
    public Customer searchCustomerById(int id) throws Exception {
        Customer customer = entityManager.find(Customer.class, id);
//        customer.getTags();
        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() throws Exception {
        return entityManager.createNamedQuery(Customer.GET_ALL_QUERY_NAME).getResultList();
    }

  
    

    @Override
    public void removeCustomer(int customerId) throws Exception {
        Customer customer = this.searchCustomerById(customerId);

        if (customer != null) {
            entityManager.remove(customer);
        }
    }

    @Override
    public void editCustomer(Customer customer) throws Exception {   
         try {
            entityManager.merge(customer);
        } catch (Exception ex) {
            
        }
    }

	@Override
	public List<Customer> searchCustomerByName(String customerName) throws Exception {

		 String jpql = "select e from Customer e where e.customerName = (?1)";

	        Query query = entityManager.createQuery(jpql);

	        query = query.setParameter(1, customerName);

	        List<Customer> list = query.getResultList();


       return list;
	}

	@Override
	public List<Customer> searchCustomerByCreatorId(int creatorId) throws Exception {
	
		return null;
	}



	
}
