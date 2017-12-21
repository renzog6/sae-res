package ar.com.res;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Renzo
 */
@ManagedBean(name = "dtSessionBean")
@SessionScoped
public class SessionBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public String goHome() {
        return "/welcome?faces-redirect=true";
    }

    public String checkLogin() {
        return "/welcome?faces-redirect=true";
    }
    
    public String logout() {
        System.out.println("ar.com.rcm.SessionBean.logout()");
        return "/index?faces-redirect=true";
    }
}
