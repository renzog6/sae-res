/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.res.rrhh;

import ar.com.res.rrhh.utils.FamiliaTipo;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Renzo
 */
@Entity
@Table(name = "rh_familia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Familia.findAll", query = "SELECT f FROM Familia f")
    , @NamedQuery(name = "Familia.findByIdFamilia", query = "SELECT f FROM Familia f WHERE f.idFamilia = :idFamilia")
    , @NamedQuery(name = "Familia.findByRelacion", query = "SELECT f FROM Familia f WHERE f.relacion = :relacion")
    , @NamedQuery(name = "Familia.findByIdPersona", query = "SELECT f FROM Familia f WHERE f.idPersona = :idPersona")})
public class Familia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_familia")
    private Long idFamilia;
    
    @Column(name = "relacion")
    private FamiliaTipo relacion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_persona")
    private long idPersona;
    @JoinTable(name = "rh_persona_familia", joinColumns = {
        @JoinColumn(name = "id_familia", referencedColumnName = "id_familia")}, inverseJoinColumns = {
        @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")})
    @ManyToMany
    private List<Persona> personaList;

    public Familia() {
    }

    public Familia(Long idFamilia) {
        this.idFamilia = idFamilia;
    }

    public Familia(Long idFamilia, long idPersona) {
        this.idFamilia = idFamilia;
        this.idPersona = idPersona;
    }

    public Long getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(Long idFamilia) {
        this.idFamilia = idFamilia;
    }

    public FamiliaTipo getRelacion() {
        return relacion;
    }

    public void setRelacion(FamiliaTipo relacion) {
        this.relacion = relacion;
    }

    public long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFamilia != null ? idFamilia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Familia)) {
            return false;
        }
        Familia other = (Familia) object;
        if ((this.idFamilia == null && other.idFamilia != null) || (this.idFamilia != null && !this.idFamilia.equals(other.idFamilia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.rcm.rrhh.Familia[ idFamilia=" + idFamilia + " ]";
    }
    
}
