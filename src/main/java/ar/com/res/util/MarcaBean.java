package ar.com.res.util;

import ar.com.res.util.ejb.MarcaFacadeLocal;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Renzo
 */
@ManagedBean(name = "dtMarcaBean")
@SessionScoped
public class MarcaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(MarcaBean.class.getName());

    @EJB
    private MarcaFacadeLocal daoMarca;

    private List<Marca> list;
    private Marca marca;

    @PostConstruct
    public void init() {
        System.out.println(LOG.toString());
    }

    public void initList() {
        list = daoMarca.findAll();
    }

    public void initCreate() {
        marca = new Marca();
    }

    public void create() {
        try {
            daoMarca.create(marca);
            marca = new Marca();
            initList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initRemove(long id) {
        marca = daoMarca.find(id);
        System.out.println(marca.getNombre());
    }

    public void remove() {
        try {
            daoMarca.remove(marca);
            marca = new Marca();
            initList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String update() {
        System.out.println("ar.com.rcm.rrhh.MarcaBean.update()");
        String dir = "";
        try {

            daoMarca.edit(marca);
            list = daoMarca.findAll();
            marca = new Marca();

            dir = "/rrhh/marca_list?faces-redirect=true";
        } catch (Exception e) {
            dir = "/templates/error.xhtml";
        }
        return dir;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Marca> getList() {
        return list;
    }

    public void setList(List<Marca> list) {
        this.list = list;
    }

    public void destroyWorld() {
        addMessage("System Error", "Please try again later.");
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
