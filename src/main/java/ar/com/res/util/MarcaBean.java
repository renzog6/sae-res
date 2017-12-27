package ar.com.res.util;

import ar.com.res.rrhh.utils.EstadoCivilTipo;
import ar.com.res.rrhh.utils.GeneroTipo;
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
@ManagedBean(name = "dtMarcaBean")
@SessionScoped
public class MarcaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(MarcaBean.class.getName());

    @EJB
    private MarcaFacadeLocal daoMarca;

    private List<Marca> list;
    private List<Marca> filter;
    private Marca marca;
    private Marca selected;

    private int temp;

    private Date fecha_actual;

    @PostConstruct
    public void init() {
        fecha_actual = new Date();
    }

    public String newMarca() {
        marca = new Marca();
        return "/rrhh/marca_form?faces-redirect=true";
    }

    public String listMarca() {
        System.out.println("ar.com.rcm.rrhh.MarcaBean.listMarca()");
        list = daoMarca.findAll();
        return "/rrhh/marca_list?faces-redirect=true";
    }

    public GeneroTipo[] getSexos() {
        return GeneroTipo.values();
    }

    public EstadoCivilTipo[] getEstadosCivil() {
        return EstadoCivilTipo.values();
    }

    public String save() {
        System.out.println("ar.com.rcm.rrhh.MarcaBean.save()");
        String dir = "";
        try {

            daoMarca.create(marca);
            list = daoMarca.findAll();
            marca = new Marca();

            dir = "/rrhh/marca_list?faces-redirect=true";
        } catch (Exception e) {
            dir = "/templates/error.xhtml";
        }
        return dir;
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

    public String view() {
        System.out.println("ar.com.rcm.rrhh.MarcaBean.view()");
        String dir = "";
        try {

            this.marca = this.selected;

            dir = "/rrhh/marca_view?faces-redirect=true";
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

    public List<Marca> getFilter() {
        return filter;
    }

    public void setFilter(List<Marca> filter) {
        this.filter = filter;
    }

    public Date getFecha_actual() {
        return fecha_actual = new Date();
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public Marca getSelected() {
        return selected;
    }

    public void setSelected(Marca selected) {
        this.selected = selected;
    }

}
