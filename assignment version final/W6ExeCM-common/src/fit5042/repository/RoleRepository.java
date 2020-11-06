package fit5042.repository;

import java.util.List;

import javax.ejb.Remote;

import fit5042.repository.entities.Role;
@Remote
public interface RoleRepository {

	/**
     * Add the role being passed as parameter into the repository
     *
     * @param role - the role to add
     */
    public void addRole(Role role) throws Exception;

    /**
     * Search for a role by its role ID
     *
     * @param id - the roleId of the role to search for
     * @return the role found
     */
    public Role searchRoleById(int id) throws Exception;

    /**
     * Return all the properties in the repository
     *
     * @return all the properties in the repository
     */
    public List<Role> getAllRoles() throws Exception;
    

    
    /**
     * Remove the role, whose role ID matches the one being passed as parameter, from the repository
     *
     * @param roleId - the ID of the role to remove
     */
    public void removeRole(int roleId) throws Exception;
    
    /**
     * Update a role in the repository
     *
     * @param role - the updated information regarding a role
     */
    public void editRole(Role role) throws Exception;
    
   

}
