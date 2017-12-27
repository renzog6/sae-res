/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.equipo.dao;

import ar.com.equipo.EquipoModelo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Renzo
 */
@Local
public interface EquipoModeloFacadeLocal {

    void create(EquipoModelo equipoModelo);

    void edit(EquipoModelo equipoModelo);

    void remove(EquipoModelo equipoModelo);

    EquipoModelo find(Object id);

    List<EquipoModelo> findAll();

    List<EquipoModelo> findRange(int[] range);

    int count();
    
}
