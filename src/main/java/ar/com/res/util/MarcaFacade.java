/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.res.util;

import ar.com.equipo.dao.AbstractFacade;
import ar.com.res.util.Marca;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Renzo
 */
@Stateless
public class MarcaFacade extends AbstractFacade<Marca> implements MarcaFacadeLocal {

    @PersistenceContext(unitName = "sae-res-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MarcaFacade() {
        super(Marca.class);
    }
    
}
