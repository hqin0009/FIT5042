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

@ManagedBean(name = "contactManagedBean")
@SessionScoped
public class ContactManageBean {

}
