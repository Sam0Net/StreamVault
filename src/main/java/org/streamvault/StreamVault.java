import org.streamvault.conexion.Conexion;
import org.streamvault.model.contenido.*;
import org.streamvault.model.usuario.*;
import org.streamvault.model.historial.Reproduccion;
import org.streamvault.persistencia.*;
import org.streamvault.repositorio.Repositorio;

import java.time.LocalDateTime;
import java.util.Scanner;

public class StreamVault {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsuarioDB usuarioDB = new UsuarioDB();
        ContenidoDB contenidoDB = new ContenidoDB();
        ReproduccionDB reproDAO = new ReproduccionDB();
        Repositorio<Reproduccion> repoMemoria = new Repositorio<>();

        while (true) {
            System.out.println("\n=== PLATAFORMA STREAMVAULT ===");
            System.out.println("1. Registrar Usuario (Uso de UsuarioFree / UsuarioPremium)");
            System.out.println("2. Registrar Contenido (Uso de Pelicula / Serie / Episodio)");
            System.out.println("3. Registrar Reproduccion (Uso de Record Reproduccion)");
            System.out.println("4. Consultar Historial (Uso de Repositorio Generico + Streams)");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 5) {
                Conexion.desconectar();
                break;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nom = scanner.nextLine();
                    System.out.print("Email: ");
                    String em = scanner.nextLine();
                    System.out.print("Contraseña: ");
                    String pass = scanner.nextLine();

                    System.out.print("Tipo (1: Free, 2: Premium): ");
                    int tipoU = scanner.nextInt();
                    scanner.nextLine(); // <-- CRÍTICO: Limpia el salto de línea del búfer de la consola
                    Usuario nuevoUsuario;
                    if (tipoU == 2) {
                        nuevoUsuario = new UsuarioPremium(nom, em, pass);
                    } else {
                        nuevoUsuario = new UsuarioFree(nom, em, pass);
                    }
                    usuarioDB.guardar(nuevoUsuario);
                    break;

                case 2:
                    System.out.print("ID Contenido: ");
                    String id = scanner.nextLine();
                    System.out.print("Titulo: ");
                    String tit = scanner.nextLine();
                    System.out.print("Genero: ");
                    String gen = scanner.nextLine();
                    System.out.print("Anio: ");
                    int anio = scanner.nextInt();
                    System.out.print("Calificacion: ");
                    double cal = scanner.nextDouble();
                    System.out.print("Tipo (1: Pelicula, 2: Serie, 3: Episodio): ");
                    int tipoC = scanner.nextInt();
                    scanner.nextLine();

                    Contenido nuevoContenido = null;

                    if (tipoC == 1) {
                        System.out.print("Duracion: ");
                        int dur = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Director: ");
                        String dir = scanner.nextLine();
                        System.out.print("Clasificacion: ");
                        String cla = scanner.nextLine();

                        nuevoContenido = new Pelicula(id, tit, gen, anio, cal, dur, dir, cla);
                    } else if (tipoC == 2) {
                        System.out.print("Temporadas: ");
                        int temp = scanner.nextInt();
                        scanner.nextLine();

                        nuevoContenido = new Serie(id, tit, gen, anio, cal, temp);
                    } else if (tipoC == 3) {
                        System.out.print("Numero de episodio: ");
                        int num = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Titulo del episodio: ");
                        String titEp = scanner.nextLine();
                        System.out.print("Duracion: ");
                        int durEp = scanner.nextInt();
                        scanner.nextLine();

                        nuevoContenido = new Episodio(id, tit, gen, anio, cal, num, titEp, durEp);
                    }

                    if (nuevoContenido != null) {
                        contenidoDB.guardar(nuevoContenido);
                    }
                    break;

                case 3:
                    System.out.print("ID Usuario (DB): ");
                    int idUser = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("ID Contenido (DB): ");
                    String idCont = scanner.nextLine();
                    System.out.print("Tiempo reproducido (segundos): ");
                    int tiempo = scanner.nextInt();

                    // Uso del Record de la Fase 6
                    Reproduccion repro = new Reproduccion(idCont, "", LocalDateTime.now(), tiempo);
                    reproDAO.guardar(idUser, repro);
                    break;

                case 4:
                    System.out.print("ID Usuario a consultar: ");
                    int idBuscar = scanner.nextInt();

                    // Carga desde SQL Server hacia el Repositorio Generico en memoria
                    repoMemoria = new Repositorio<>();
                    reproDAO.obtenerPorUsuario(idBuscar).forEach(repoMemoria::agregar);

                    System.out.println("\n--- Historial en Repositorio Generico ---");
                    repoMemoria.obtenerTodos().forEach(r ->
                            System.out.println("Contenido: " + r.idContenido() + " | Duracion: " + r.duracionSeg() + "s")
                    );
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        }
        scanner.close();
    }
}