package ar.com.res.rrhh;

import ar.com.res.rrhh.dao.PersonaFacadeLocal;
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
@ManagedBean(name = "dtPersonaBean")
@SessionScoped
public class PersonaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(PersonaBean.class.getName());

    @EJB
    private PersonaFacadeLocal daoPersona;

    private List<Persona> list;
    private List<Persona> filter;
    private Persona persona;
    private Persona selected;

    private int temp;

    private Date fecha_actual;

    @PostConstruct
    public void initPersona() {
        fecha_actual = new Date();
    }

    public String newPersona() {
        persona = new Persona();
        return "/rrhh/persona_form?faces-redirect=true";
    }

    public String listPersona() {
        System.out.println("ar.com.rcm.rrhh.PersonaBean.listPersona()");
        list = daoPersona.findAll();
        return "/rrhh/persona_list?faces-redirect=true";
    }

    public GeneroTipo[] getSexos() {
        return GeneroTipo.values();
    }

    public EstadoCivilTipo[] getEstadosCivil() {
        return EstadoCivilTipo.values();
    }

    public String save() {
        System.out.println("ar.com.rcm.rrhh.PersonaBean.save()");
        String dir = "";
        try {

            daoPersona.create(persona);
            list = daoPersona.findAll();
            persona = new Persona();

            dir = "/rrhh/persona_list?faces-redirect=true";
        } catch (Exception e) {
            dir = "/templates/error.xhtml";
        }
        return dir;
    }
    
        public String update() {
        System.out.println("ar.com.rcm.rrhh.PersonaBean.update()");
        String dir = "";
        try {

            daoPersona.edit(persona);
            list = daoPersona.findAll();
            persona = new Persona();

            dir = "/rrhh/persona_list?faces-redirect=true";
        } catch (Exception e) {
            dir = "/templates/error.xhtml";
        }
        return dir;
    }

    public String view() {
        System.out.println("ar.com.rcm.rrhh.PersonaBean.view()");
        String dir = "";
        try {

            this.persona = this.selected;

            dir = "/rrhh/persona_view?faces-redirect=true";
        } catch (Exception e) {
            dir = "/templates/error.xhtml";
        }
        return dir;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getList() {
        return list;
    }

    public void setList(List<Persona> list) {
        this.list = list;
    }

    public List<Persona> getFilter() {
        return filter;
    }

    public void setFilter(List<Persona> filter) {
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

    public Persona getSelected() {
        return selected;
    }

    public void setSelected(Persona selected) {
        this.selected = selected;
    }

}
