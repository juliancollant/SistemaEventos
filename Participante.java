import java.io.Serializable;

public class Participante implements Serializable {
    private String nombre;
    private String AKA;
    private String apuesta;

    public Participante(String nombre, String AKA, String apuesta) {
        this.nombre = nombre;
        this.AKA = AKA;
        this.apuesta = apuesta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAKA() {
        return AKA;
    }

    public void setAKA(String AKA) {
        this.AKA = AKA;
    }

    public String getApuesta() {
        return apuesta;
    }

    public void setApuesta(String apuesta) {
        this.apuesta = apuesta;
    }
}
