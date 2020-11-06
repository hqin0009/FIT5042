package fit5042.mBeans;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
//import javax.mail.Address;

import fit5042.repository.RoleRepository;
import fit5042.repository.entities.Role;

@ManagedBean(name = "roleManagedBean")
@SessionScoped

public class RoleManagedBean implements Serializable {

    @EJB
    RoleRepository roleRepository;

    /**
     * Creates a new instance of RoleManagedBean
     */
    public RoleManagedBean() {
    }

    public List<Role> getAllRoles() {
        try {
            List<Role> properties = roleRepository.getAllRoles();
            return properties;
        } catch (Exception ex) {
            Logger.getLogger(RoleManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void addRole(Role role) 
    {
        try {
             roleRepository.addRole(role);
        } catch (Exception ex) {
            Logger.getLogger(RoleManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Search a role by Id
     */
    public Role searchRoleById(int id)
    {
        try {
            return roleRepository.searchRoleById(id);
        } catch (Exception ex) {
            Logger.getLogger(RoleManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
  
  

    public void removeRole(int roleId) 
    {
        try {
            roleRepository.removeRole(roleId);
        } catch (Exception ex) {
            Logger.getLogger(RoleManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editRole(Role role)
    {
        try {
            
            roleRepository.editRole(role);
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Role has been updated succesfully"));
        } catch (Exception ex) {
            Logger.getLogger(RoleManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  

  
   
   
}

