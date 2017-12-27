/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.equipo;

import ar.com.res.util.Marca;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Renzo
 */
@Entity
@Table(name = "eq_equipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e")
    , @NamedQuery(name = "Equipo.findByIdEquipo", query = "SELECT e FROM Equipo e WHERE e.id = :id")
    , @NamedQuery(name = "Equipo.findByAnio", query = "SELECT e FROM Equipo e WHERE e.anio = :anio")
    , @NamedQuery(name = "Equipo.findByChasis", query = "SELECT e FROM Equipo e WHERE e.chasis = :chasis")
    , @NamedQuery(name = "Equipo.findByMotor", query = "SELECT e FROM Equipo e WHERE e.motor = :motor")
    , @NamedQuery(name = "Equipo.findByPatente", query = "SELECT e FROM Equipo e WHERE e.patente = :patente")
    , @NamedQuery(name = "Equipo.findByColor", query = "SELECT e FROM Equipo e WHERE e.color = :color")
    , @NamedQuery(name = "Equipo.findByOtro", query = "SELECT e FROM Equipo e WHERE e.otro = :otro")})
public class Equipo implements Serializable {

    @JoinColumn(name = "categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    private EquipoCategoria categoria;
    @JoinColumn(name = "marca", referencedColumnName = "id_marca")
    @ManyToOne
    private Marca marca;
    @JoinColumn(name = "modelo", referencedColumnName = "id_modelo")
    @ManyToOne(optional = false)
    private EquipoModelo modelo;
    @JoinColumn(name = "tipo", referencedColumnName = "id_tipo")
    @ManyToOne(optional = false)
    private EquipoTipo tipo;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_equipo")
    private Long id;
    @Size(max = 20)
    @Column(name = "anio")
    private String anio;
    @Size(max = 20)
    @Column(name = "chasis")
    private String chasis;
    @Size(max = 20)
    @Column(name = "motor")
    private String motor;
    @Size(max = 20)
    @Column(name = "patente")
    private String patente;
    @Size(max = 20)
    @Column(name = "color")
    private String color;
    @Size(max = 20)
    @Column(name = "otro")
    private String otro;
    
    public Equipo() {
    }

    public Equipo(Long id) {
        this.id = id;
    }

    public Long getIdEquipo() {
        return id;
    }

    public void setIdEquipo(Long id) {
        this.id = id;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOtro() {
        return otro;
    }

    public void setOtro(String otro) {
        this.otro = otro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Equipo other = (Equipo) obj;
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "ar.com.equipo.Equipo[ id=" + id + " ]";
    }

    public EquipoCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(EquipoCategoria categoria) {
        this.categoria = categoria;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public EquipoModelo getModelo() {
        return modelo;
    }

    public void setModelo(EquipoModelo modelo) {
        this.modelo = modelo;
    }

    public EquipoTipo getTipo() {
        return tipo;
    }

    public void setTipo(EquipoTipo tipo) {
        this.tipo = tipo;
    }
    
}
