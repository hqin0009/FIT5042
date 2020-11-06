package fit5042.controllers;


import java.util.ArrayList;

import javax.el.ELContext;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.mBeans.RoleManagedBean;
import fit5042.repository.entities.Role;

@Named(value = "roleApplication")
@ApplicationScoped

public class RoleApplication {
   
    @ManagedProperty(value="#{roleManagedBean}") 
    RoleManagedBean roleManagedBean;
    
    private ArrayList<Role> roles;

    private boolean showForm = true;
  
    public boolean isShowForm() {
        return showForm;
    }

   
    public RoleApplication() throws Exception {       
        roles = new ArrayList<>();
        
       
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        roleManagedBean = (RoleManagedBean) FacesContext.getCurrentInstance().getApplication()
        .getELResolver().getValue(elContext, null, "roleManagedBean");
        
        
        updateRoleList();
    }

    public ArrayList<Role> getRoles() {
        return roles;
    }
    
    private void setRoles(ArrayList<Role> newRoles) {
        this.roles = newRoles;
    }
    
   
    public void updateRoleList()
    {
        if (roles != null && roles.size() > 0)
        {
            
        }
        else
        {
            roles.clear();

            for (Role role : roleManagedBean.getAllRoles())
            {
                roles.add(role);
            }

            setRoles(roles);
        }
    }
    
    public void searchRoleById(int roleId)
    {
        roles.clear();
        
        roles.add(roleManagedBean.searchRoleById(roleId));
    }
    
  
    
    public void searchAll()
    {
        roles.clear();
        
        for (Role role : roleManagedBean.getAllRoles())
        {
            roles.add(role);
        }
        
        setRoles(roles);
    }
}

