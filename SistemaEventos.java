import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
public class SistemaEventos {
    private List<Evento> eventos;
    private List<Participante> participantes;

    public static void main(String[] args) {
        SistemaEventos sistema = new SistemaEventos();
        sistema.mostrarMenu();
    }

    public SistemaEventos() {
        this.eventos = new ArrayList<>();
        this.participantes = new ArrayList<>();

        eventos.add(new Evento("Competencia de natación", "2023-12-15", "Piscina Municipal", "Competencia de natación amateur"));
        eventos.add(new Evento("Carrera solidaria", "2023-11-28", "Parque Central", "Carrera de 5 km para recaudar fondos"));
        eventos.add(new Evento("Concierto benéfico", "2023-12-10", "Teatro Municipal", "Concierto a beneficio de organizaciones caritativas"));
    }

    private void mostrarMenu() {
        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Lista de eventos disponibles en la ciudad");
            System.out.println("2. Crear evento");
            System.out.println("3. Participar en un evento");
            System.out.println("4. Eliminar participación");
            System.out.println("5. Lista de participantes");
            System.out.println("6. Guardar datos agregados recientemente");
            System.out.println("7. Cargar datos agregados anteriormente");
            System.out.println("8. Eliminar evento");
            System.out.println("9.SALIR");

            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    mostrarEventosDisponibles();
                    break;
                case 2:
                    crearEvento();
                    break;
                case 3:
                    participarEnEvento();
                    break;
                case 4:
                    eliminarParticipacion();
                    break;
                case 5:
                   listarParticipantes();
                    break;
                case  6:
                    guardarDatos();
                    break;
                case 7:
                    cargarDatos();
                    break;
                case 8:
                    eliminarEvento();
                    return;
                case 9:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }
        }
    }

    private void crearEvento () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del evento:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la fecha del evento (YYYY-MM-DD):");
        String fecha = scanner.nextLine();

        System.out.println("Ingrese el lugar del evento:");
        String lugar = scanner.nextLine();

        System.out.println("Ingrese la descripción del evento:");
        String descripcion = scanner.nextLine();

        Evento nuevoEvento = new Evento(nombre, fecha, lugar, descripcion);
        eventos.add(nuevoEvento);
        System.out.println("Nuevo evento creado correctamente.");
    }

    private void mostrarEventosDisponibles() {
        System.out.println("Eventos Disponibles:");
        for (Evento evento : eventos) {
            System.out.println("Nombre: " + evento.getNombre());
            System.out.println("Fecha: " + evento.getFecha());
            System.out.println("Lugar: " + evento.getLugar());
            System.out.println("Descripción: " + evento.getDescripcion());
            System.out.println();
        }

    }
    private void eliminarEvento() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del evento a eliminar:");
        String nombreEvento = scanner.nextLine();

        Evento eventoEncontrado = null;
        for (Evento evento : eventos) {
            if (evento.getNombre().equalsIgnoreCase(nombreEvento)) {
                eventoEncontrado = evento;
                break;
            }
        }

        if (eventoEncontrado != null) {
            eventos.remove(eventoEncontrado);
            System.out.println("Evento eliminado correctamente.");
        } else {
            System.out.println("El evento no existe.");
        }
    }


        private void participarEnEvento() {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese su nombre:");
            String nombreParticipante = scanner.nextLine();

            System.out.println("Ingrese su AKA (apodo):");
            String akaParticipante = scanner.nextLine();

            System.out.println("Ingrese el nombre del evento en el que desea participar:");
            String nombreEvento = scanner.nextLine();

            Evento eventoEncontrado = null;
            for (Evento evento : eventos) {
                if (evento.getNombre().equalsIgnoreCase(nombreEvento)) {
                    eventoEncontrado = evento;
                    break;
                }
            }

            if (eventoEncontrado != null) {
                System.out.println("Ingrese su apuesta (si aplica):");
                String apuesta = scanner.nextLine();

                Participante nuevoParticipante = new Participante(nombreParticipante, akaParticipante, apuesta);
                eventoEncontrado.agregarParticipante(nuevoParticipante);
                System.out.println("¡Usted ha sido inscrito en el evento!");
            } else {
                System.out.println("El evento no ha sido encontrado.");
            }
        }

        private void eliminarParticipacion() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el nombre del evento:");
            String nombreEvento = scanner.nextLine();

            Evento eventoEncontrado = null;
            for (Evento evento : eventos) {
                if (evento.getNombre().equalsIgnoreCase(nombreEvento)) {
                    eventoEncontrado = evento;
                    break;
                }
            }

            if (eventoEncontrado != null) {
                System.out.println("Ingrese el nombre del participante a eliminar:");
                String nombreParticipante = scanner.nextLine();

                List<Participante> participantesEvento = eventoEncontrado.getParticipantes();
                Participante participanteEncontrado = null;

                for (Participante participante : participantesEvento) {
                    if (participante.getNombre().equalsIgnoreCase(nombreParticipante)) {
                        participanteEncontrado = participante;
                        break;
                    }
                }

                if (participanteEncontrado != null) {
                    participantesEvento.remove(participanteEncontrado);
                    System.out.println("Participación eliminada correctamente del evento: " + eventoEncontrado.getNombre());
                } else {
                    System.out.println("El participante no está inscrito en el evento.");
                }
            } else {
                System.out.println("Evento no encontrado.");
            }
        }

        private void listarParticipantes() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el nombre del evento:");
            String nombreEvento = scanner.nextLine();

            Evento eventoEncontrado = null;
            for (Evento evento : eventos) {
                if (evento.getNombre().equalsIgnoreCase(nombreEvento)) {
                    eventoEncontrado = evento;
                    break;
                }
            }

            if (eventoEncontrado != null) {
                List<Participante> participantesEvento = eventoEncontrado.getParticipantes();

                if (!participantesEvento.isEmpty()) {
                    System.out.println("Participantes inscritos en el evento '" + nombreEvento + "':");
                    for (Participante participante : participantesEvento) {
                        System.out.println("Nombre: " + participante.getNombre());
                        System.out.println("AKA: " + participante.getAKA());
                        System.out.println("Apuesta: " + participante.getApuesta());
                        System.out.println();
                    }
                } else {
                    System.out.println("No hay participantes inscritos en el evento.");
                }
            } else {
                System.out.println("Evento no encontrado.");
            }
        }
    private void guardarDatos() {
        try {
            FileOutputStream fileOut = new FileOutputStream("datos.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(eventos);
            objectOut.writeObject(participantes);
            objectOut.close();
            fileOut.close();
            System.out.println("Datos guardados correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarDatos() {
        try {
            FileInputStream fileIn = new FileInputStream("datos.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            eventos = (List<Evento>) objectIn.readObject();
            participantes = (List<Participante>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se encontraron datos previos.");
        }
    }
    }


