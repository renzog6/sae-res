/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.equipo.dao;

import ar.com.equipo.EquipoTipo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Renzo
 */
@Local
public interface EquipoTipoFacadeLocal {

    void create(EquipoTipo equipoTipo);

    void edit(EquipoTipo equipoTipo);

    void remove(EquipoTipo equipoTipo);

    EquipoTipo find(Object id);

    List<EquipoTipo> findAll();

    List<EquipoTipo> findRange(int[] range);

    int count();
    
}
