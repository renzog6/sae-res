package ar.com.res.rrhh.dao;

import ar.com.res.rrhh.Familia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Renzo
 */
@Local
public interface FamiliaFacadeLocal {

    void create(Familia familia);

    void edit(Familia familia);

    void remove(Familia familia);

    Familia find(Object id);

    List<Familia> findAll();

    List<Familia> findRange(int[] range);

    int count();
    
}
