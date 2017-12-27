/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.equipo.dao;

import ar.com.equipo.EquipoCategoria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Renzo
 */
@Local
public interface EquipoCategoriaFacadeLocal {

    void create(EquipoCategoria equipoCategoria);

    void edit(EquipoCategoria equipoCategoria);

    void remove(EquipoCategoria equipoCategoria);

    EquipoCategoria find(Object id);

    List<EquipoCategoria> findAll();

    List<EquipoCategoria> findRange(int[] range);

    int count();
    
}
