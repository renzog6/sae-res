package ar.com.res.rrhh.utils;

/**
 *
 * @author Renzo
 */
public enum EstadoCivilTipo {

    SOLTERO(1, "Soltero/a"), 
    CASADO(3, "Casado/a");

    private int value;
    private String nombre;

    private EstadoCivilTipo(int value, String nombre) {
        this.value = value;
        this.nombre = nombre;
    }

    public int getValue() {
        return value;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    
}
