/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.equipo.dao;

import ar.com.equipo.EquipoTipo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Renzo
 */
@Stateless
public class EquipoTipoFacade extends AbstractFacade<EquipoTipo> implements EquipoTipoFacadeLocal {

    @PersistenceContext(unitName = "sae-res-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquipoTipoFacade() {
        super(EquipoTipo.class);
    }
    
}
