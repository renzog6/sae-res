package ar.com.res.rrhh.dao;

import ar.com.res.rrhh.Persona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Renzo
 */
@Local
public interface PersonaFacadeLocal {

    void create(Persona persona);

    void edit(Persona persona);

    void remove(Persona persona);

    Persona find(Object id);

    List<Persona> findAll();

    List<Persona> findRange(int[] range);

    int count();
    
}
