package ar.com.equipo;

import ar.com.equipo.dao.EquipoCategoriaFacadeLocal;
import ar.com.res.util.MarcaFacadeLocal;
import ar.com.res.util.Marca;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
    private List<EquipoCategoria> filter;
    private EquipoCategoria categoria;
    private EquipoCategoria selected;

    private Date fecha_actual;

    @PostConstruct
    public void init() {
        fecha_actual = new Date();
    }

    public String newEquipoCategoria() {
        categoria = new EquipoCategoria();

        return "/equipo/equipo_form?faces-redirect=true";
    }

    public String listEquipoCategoria() {
        System.out.println("ar.com.rcm.equipo.EquipoCategoriaBean.listEquipoCategoria()");
        list = daoEquipoCategoria.findAll();
        return "/equipo/equipo_list?faces-redirect=true";
    }

    public String save() {
        System.out.println("ar.com.rcm.equipo.EquipoCategoriaBean.save()");
        String dir = "";
        try {

            daoEquipoCategoria.create(categoria);
            list = daoEquipoCategoria.findAll();
            categoria = new EquipoCategoria();

            dir = "/equipo/equipo_list?faces-redirect=true";
        } catch (Exception e) {
            dir = "/templates/error.xhtml";
            e.printStackTrace();
        }
        return dir;
    }

    public String update() {
        System.out.println("ar.com.rcm.equipo.EquipoCategoriaBean.update()");
        String dir = "";
        try {

            daoEquipoCategoria.edit(categoria);
            list = daoEquipoCategoria.findAll();
            categoria = new EquipoCategoria();

            dir = "/equipo/equipo_list?faces-redirect=true";
        } catch (Exception e) {
            dir = "/templates/error.xhtml";
        }
        return dir;
    }

    public String view() {
        System.out.println("ar.com.rcm.equipo.EquipoCategoriaBean.view()");
        String dir = "";
        try {

            this.categoria = this.selected;

            dir = "/equipo/equipo_view?faces-redirect=true";
        } catch (Exception e) {
            dir = "/templates/error.xhtml";
        }
        return dir;
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

    public List<EquipoCategoria> getFilter() {
        return filter;
    }

    public void setFilter(List<EquipoCategoria> filter) {
        this.filter = filter;
    }

    public Date getFecha_actual() {
        return fecha_actual = new Date();
    }

    public EquipoCategoria getSelected() {
        return selected;
    }

    public void setSelected(EquipoCategoria selected) {
        this.selected = selected;
    }
   

}
