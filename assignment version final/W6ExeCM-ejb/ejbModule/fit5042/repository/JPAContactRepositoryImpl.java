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

import fit5042.repository.entities.Contact;
import fit5042.repository.entities.Customer;

/**
 *
 * @author Eddie Leung
 */
@Stateless
public class JPAContactRepositoryImpl implements ContactRepository {

    @PersistenceContext(unitName = "W6ExeCM-ejb")
    private EntityManager entityManager;

    @Override
    public void addContact(Contact contact) throws Exception {
    	List<Contact> properties =  entityManager.createNamedQuery(Contact.GET_ALL_QUERY_NAME).getResultList(); 
        contact.setContactId(properties.get(0).getContactId() + 1);
        entityManager.persist(contact);
    }
     
    @Override
    public Contact searchContactById(int id) throws Exception {
        Contact contact = entityManager.find(Contact.class, id);
//        contact.getTags();
        return contact;
    }

    @Override
    public List<Contact> getAllContacts() throws Exception {
        return entityManager.createNamedQuery(Contact.GET_ALL_QUERY_NAME).getResultList();
    }

  
    

    @Override
    public void removeContact(int contactId) throws Exception {
        Contact contact = this.searchContactById(contactId);

        if (contact != null) {
            entityManager.remove(contact);
        }
    }

    @Override
    public void editContact(Contact contact) throws Exception {   
         try {
            entityManager.merge(contact);
        } catch (Exception ex) {
            
        }
    }

	@Override
	public List<Contact> getContactsByCutomerId(int customerId) throws Exception {

		 String jpql = "select e from Contact e where e.customerId = (?1)";

	        Query query = entityManager.createQuery(jpql);


	        query = query.setParameter(1, customerId);

	        List<Contact> list = query.getResultList();


      return list;
	}

	@Override
	public List<Contact> searchContactByName(String contactName) throws Exception {

		 String jpql = "select c from Contact c where c.contactName = (?1)";

	        Query query = entityManager.createQuery(jpql);

	
	        query = query.setParameter(1, contactName);

	        List<Contact> list = query.getResultList();

       return list;
	}

}
