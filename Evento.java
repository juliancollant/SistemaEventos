import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Evento implements Serializable {
    private String nombre;
    private String fecha;
    private String lugar;
    private String descripcion;
    private List<Participante> participantes;

    public Evento(String nombre, String fecha, String lugar, String descripcion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.descripcion = descripcion;
        participantes = new ArrayList<>();
    }

    public String getNombre() {return nombre;}

    public String getFecha() {
        return fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public void agregarParticipante(Participante nuevoParticipante) {

    }

    // Getters y setters para los campos del evento
}
