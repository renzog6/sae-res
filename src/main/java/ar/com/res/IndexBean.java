package ar.com.res;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Renzo
 */
@ManagedBean(name = "dtIndexBean")
@SessionScoped
public class IndexBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public String goHome() {
        return "/welcome?faces-redirect=true";
    }
    



}
