package ar.com.equipo;

import ar.com.equipo.dao.EquipoCategoriaFacadeLocal;
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
@ManagedBean(name = "dtEquipoCategoriaBean")
@SessionScoped
public class EquipoCategoriaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(EquipoCategoriaBean.class.getName());

    @EJB
    private EquipoCategoriaFacadeLocal daoEquipoCategoria;

    private List<EquipoCategoria> list;
    private EquipoCategoria categoria;

    @PostConstruct
    public void init() {
        System.out.println(LOG.toString());
    }

    public void initList() {
        list = daoEquipoCategoria.findAll();
    }

    public void initCreate() {
        categoria = new EquipoCategoria();
    }

    public void create() {
        try {
            daoEquipoCategoria.create(categoria);
            categoria = new EquipoCategoria();
            initList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initRemove(long id) {
        categoria = daoEquipoCategoria.find(id);
        System.out.println(categoria.getNombre());
    }

    public void remove() {
        try {
            daoEquipoCategoria.remove(categoria);
            categoria = new EquipoCategoria();
            initList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public EquipoCategoria getEquipoCategoria() {
        return categoria;
    }

    public void setEquipoCategoria(EquipoCategoria categoria) {
        this.categoria = categoria;
    }

    public List<EquipoCategoria> getList() {
        return list;
    }

    public void setList(List<EquipoCategoria> list) {
        this.list = list;
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
