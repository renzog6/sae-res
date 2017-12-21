package ar.com.res.rrhh.utils;
/**
 *
 * @author Renzo
 */
public enum GeneroTipo {

    M(1, "Masculino"), F(3, "Femenino");

    private int value;
    private String sexo;

    private GeneroTipo(int value, String nombre) {
        this.value = value;
        this.sexo = nombre;
    }

    public int getValue() {
        return value;
    }

    public String getNombre() {
        return sexo;
    }

    @Override
    public String toString() {
        return sexo;
    }

    
}
