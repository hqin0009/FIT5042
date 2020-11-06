package fit5042.repository.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity  
@Table(name="role") 
@NamedQueries({
    @NamedQuery(name = Role.GET_ALL_QUERY_NAME, query = "SELECT p FROM Role p order by p.roleId desc")})
public class Role implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String GET_ALL_QUERY_NAME = "Role.getAll";
	
	@Id  
    @GeneratedValue(strategy = GenerationType.AUTO)  
	private int roleId;
	private String roleName;
	private String roleDes;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDes() {
		return roleDes;
	}
	public void setRoleDes(String roleDes) {
		this.roleDes = roleDes;
	}
	
	
}
