package ar.com.res.rrhh.utils;

/**
 *
 * @author Renzo
 */
public enum FamiliaTipo {

    PAREJA(1, "Pareja"), 
    HIJO(3, "Hijo"),
    MADRE(5, "Madre"),
    PADRE(7, "Padre");

    private int value;
    private String nombre;

    private FamiliaTipo(int value, String nombre) {
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
