package ar.com.equipo;

import ar.com.equipo.dao.EquipoCategoriaFacadeLocal;
import ar.com.equipo.dao.EquipoFacadeLocal;
import ar.com.equipo.dao.EquipoModeloFacadeLocal;
import ar.com.equipo.dao.EquipoTipoFacadeLocal;
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
@ManagedBean(name = "dtEquipoBean")
@SessionScoped
public class EquipoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(EquipoBean.class.getName());

    @EJB
    private EquipoFacadeLocal daoEquipo;

    private List<Equipo> list;
    private List<Equipo> filter;
    private Equipo equipo;
    private Equipo selected;

    @EJB
    private EquipoCategoriaFacadeLocal daoCategoria;
    private List<EquipoCategoria> listCategoria;
    private Long idCategoria;

    @EJB
    private EquipoTipoFacadeLocal daoTipo;
    private List<EquipoTipo> listTipo;
    private Long idTipo;

    @EJB
    private EquipoModeloFacadeLocal daoModelo;
    private List<EquipoModelo> listModelo;
    private Long idModelo;
    
    @EJB
    private MarcaFacadeLocal ejbMarca;
    private List<Marca> listMarca;
    private Long idMarca;

    private Date fecha_actual;

    @PostConstruct
    public void init() {
        fecha_actual = new Date();
    }

    public String newEquipo() {
        equipo = new Equipo();

        listCategoria = daoCategoria.findAll();
        idCategoria = (long) -1;
        listTipo = daoTipo.findAll();
        idTipo = (long) -1;
        listModelo = daoModelo.findAll();
        idModelo = (long) -1;
        listMarca = ejbMarca.findAll();
        idMarca = (long) -1;

        return "/equipo/equipo_form?faces-redirect=true";
    }

    public String listEquipo() {
        System.out.println("ar.com.rcm.equipo.EquipoBean.listEquipo()");
        list = daoEquipo.findAll();
        return "/equipo/equipo_list?faces-redirect=true";
    }

    public String save() {
        System.out.println("ar.com.rcm.equipo.EquipoBean.save()");
        String dir = "";
        try {

            equipo.setCategoria(daoCategoria.find(idCategoria));
            equipo.setTipo(daoTipo.find(idTipo));
            equipo.setModelo(daoModelo.find(idModelo));
            equipo.setMarca(ejbMarca.find(idMarca));
            
            daoEquipo.create(equipo);
            list = daoEquipo.findAll();
            equipo = new Equipo();

            dir = "/equipo/equipo_list?faces-redirect=true";
        } catch (Exception e) {
            dir = "/templates/error.xhtml";
            e.printStackTrace();
        }
        return dir;
    }

    public String update() {
        System.out.println("ar.com.rcm.equipo.EquipoBean.update()");
        String dir = "";
        try {

            daoEquipo.edit(equipo);
            list = daoEquipo.findAll();
            equipo = new Equipo();

            dir = "/equipo/equipo_list?faces-redirect=true";
        } catch (Exception e) {
            dir = "/templates/error.xhtml";
        }
        return dir;
    }

    public String view() {
        System.out.println("ar.com.rcm.equipo.EquipoBean.view()");
        String dir = "";
        try {

            this.equipo = this.selected;

            dir = "/equipo/equipo_view?faces-redirect=true";
        } catch (Exception e) {
            dir = "/templates/error.xhtml";
        }
        return dir;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public List<Equipo> getList() {
        return list;
    }

    public void setList(List<Equipo> list) {
        this.list = list;
    }

    public List<Equipo> getFilter() {
        return filter;
    }

    public void setFilter(List<Equipo> filter) {
        this.filter = filter;
    }

    public Date getFecha_actual() {
        return fecha_actual = new Date();
    }

    public Equipo getSelected() {
        return selected;
    }

    public void setSelected(Equipo selected) {
        this.selected = selected;
    }

    public List<EquipoCategoria> getListCategoria() {
        return listCategoria;
    }

    public void setListCategoria(List<EquipoCategoria> listCategoria) {
        this.listCategoria = listCategoria;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public List<EquipoTipo> getListTipo() {
        return listTipo;
    }

    public void setListTipo(List<EquipoTipo> listTipo) {
        this.listTipo = listTipo;
    }

    public List<EquipoModelo> getListModelo() {
        return listModelo;
    }

    public void setListModelo(List<EquipoModelo> listModelo) {
        this.listModelo = listModelo;
    }

    public Long getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Long idTipo) {
        this.idTipo = idTipo;
    }

    public Long getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Long idModelo) {
        this.idModelo = idModelo;
    }

    public List<Marca> getListMarca() {
        return listMarca;
    }

    public void setListMarca(List<Marca> listMarca) {
        this.listMarca = listMarca;
    }

    public Long getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
    }

}
