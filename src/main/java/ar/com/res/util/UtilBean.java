package ar.com.res.util;

import ar.com.equipo.EquipoCategoriaBean;
import ar.com.res.util.ejb.MarcaFacadeLocal;
import ar.com.res.rrhh.utils.EstadoCivilTipo;
import ar.com.res.rrhh.utils.GeneroTipo;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Renzo
 */
@ManagedBean(name = "dtUtilBean")
@SessionScoped
public class UtilBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(UtilBean.class.getName());

    @ManagedProperty("#{dtMarcaBean}")
    private MarcaBean marcaBean;

    @ManagedProperty("#{dtEquipoCategoriaBean}")
    private EquipoCategoriaBean equipoCategoriaBean;

    public void init() {
        marcaBean.initList();
        equipoCategoriaBean.initList();
    }

    public MarcaBean getMarcaBean() {
        return marcaBean;
    }

    public void setMarcaBean(MarcaBean marcaBean) {
        this.marcaBean = marcaBean;
    }

    public EquipoCategoriaBean getEquipoCategoriaBean() {
        return equipoCategoriaBean;
    }

    public void setEquipoCategoriaBean(EquipoCategoriaBean equipoCategoriaBean) {
        this.equipoCategoriaBean = equipoCategoriaBean;
    }

}
