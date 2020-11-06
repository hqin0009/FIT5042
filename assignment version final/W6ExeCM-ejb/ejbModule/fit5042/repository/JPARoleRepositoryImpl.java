package fit5042.repository;


import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import fit5042.repository.entities.Role;

/**
 *
 * @author Eddie Leung
 */
@Stateless
public class JPARoleRepositoryImpl implements RoleRepository {

    @PersistenceContext(unitName = "W6ExeCM-ejb")
    private EntityManager entityManager;

    @Override
    public void addRole(Role role) throws Exception {
    	List<Role> properties =  entityManager.createNamedQuery(Role.GET_ALL_QUERY_NAME).getResultList(); 
        role.setRoleId(properties.get(0).getRoleId() + 1);
        entityManager.persist(role);
    }
     
    @Override
    public Role searchRoleById(int id) throws Exception {
        Role role = entityManager.find(Role.class, id);
//        role.getTags();
        return role;
    }

    @Override
    public List<Role> getAllRoles() throws Exception {
        return entityManager.createNamedQuery(Role.GET_ALL_QUERY_NAME).getResultList();
    }

  
    

    @Override
    public void removeRole(int roleId) throws Exception {
        Role role = this.searchRoleById(roleId);

        if (role != null) {
            entityManager.remove(role);
        }
    }

    @Override
    public void editRole(Role role) throws Exception {   
         try {
            entityManager.merge(role);
        } catch (Exception ex) {
            
        }
    }

}
