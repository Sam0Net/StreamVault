package org.streamvault;

import org.streamvault.conexion.Conexion;
import org.streamvault.model.contenido.*;
import org.streamvault.model.usuario.*;
import org.streamvault.model.historial.Reproduccion;
import org.streamvault.persistencia.*;
import org.streamvault.repositorio.Repositorio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class StreamVault {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsuarioDB usuarioDB = new UsuarioDB();
        ContenidoDB contenidoDB = new ContenidoDB();
        PlanDB planDB = new PlanDB();
        SuscripcionDB suscripcionDB = new SuscripcionDB();
        ReproduccionDB reproDB = new ReproduccionDB();
        Repositorio<Reproduccion> repoMemoria = new Repositorio<>();

        while (true) {
            System.out.println("\n=== MENU PLATAFORMA STREAMVAULT ===");
            System.out.println("1. Registrar Usuario");
            System.out.println("2. Registrar Contenido (Pelicula/Serie/Episodio)");
            System.out.println("3. Registrar Reproduccion (Historial - Create)");
            System.out.println("4. Consultar Historial (Read via Streams)");
            System.out.println("5. Actualizar Duracion de Reproduccion (Update)");
            System.out.println("6. Eliminar Registro de Reproduccion (Delete)");
            System.out.println("7. Crear Plan de Suscripcion");
            System.out.println("8. Asignar Suscripcion a un Usuario");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 9) {
                Conexion.desconectar();
                System.out.println("Programa finalizado.");
                break;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nom = scanner.nextLine();
                    System.out.print("Email: ");
                    String em = scanner.nextLine();
                    System.out.print("Contrasena: ");
                    String pass = scanner.nextLine();
                    System.out.print("Tipo (1: Free, 2: Premium): ");
                    int tipoU = scanner.nextInt();
                    scanner.nextLine();

                    Usuario nuevoUsuario = (tipoU == 2) ? new UsuarioPremium(nom, em, pass) : new UsuarioFree(nom, em, pass);
                    usuarioDB.guardar(nuevoUsuario);
                    break;

                case 2:
                    System.out.print("ID Contenido (Max 10 caracteres): ");
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
                        System.out.print("Duracion (segundos): ");
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
                        System.out.print("Duracion (segundos): ");
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
                    System.out.print("ID Contenido: ");
                    String idCont = scanner.nextLine();
                    System.out.print("Duracion reproducida (segundos): ");
                    int tiempo = scanner.nextInt();
                    scanner.nextLine();

                    // Se instancia el Record pasandole una fecha actual
                    Reproduccion repro = new Reproduccion(idCont, "", LocalDateTime.now(), tiempo);
                    reproDB.guardar(idUser, repro);
                    break;

                case 4:
                    System.out.print("ID Usuario a consultar: ");
                    int idBuscar = scanner.nextInt();
                    scanner.nextLine();

                    repoMemoria = new Repositorio<>();
                    reproDB.obtenerPorUsuario(idBuscar).forEach(repoMemoria::agregar);

                    System.out.println("\n--- Historial en Repositorio Generico ---");
                    if (repoMemoria.obtenerTodos().isEmpty()) {
                        System.out.println("No se encontraron registros para este usuario.");
                    } else {
                        repoMemoria.obtenerTodos().forEach(r ->
                                System.out.println("Contenido ID: " + r.idContenido() + " | Titulo: " + r.titulo() + " | Fecha: " + r.fecha() + " | Duracion: " + r.duracionSeg() + "s")
                        );
                    }
                    break;

                case 5:
                    System.out.print("ID Usuario (DB): ");
                    int idUserUpd = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("ID Contenido: ");
                    String idContUpd = scanner.nextLine();
                    System.out.print("Nueva duracion (segundos): ");
                    int nuevaDur = scanner.nextInt();
                    scanner.nextLine();

                    reproDB.actualizarDuracion(idUserUpd, idContUpd, nuevaDur);
                    break;

                case 6:
                    System.out.print("ID Usuario (DB): ");
                    int idUserDel = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("ID Contenido: ");
                    String idContDel = scanner.nextLine();

                    reproDB.eliminar(idUserDel, idContDel);
                    break;

                case 7:
                    System.out.print("Nombre del Plan: ");
                    String nomPlan = scanner.nextLine();
                    System.out.print("Precio (Ej: 29.90): ");
                    double precio = scanner.nextDouble();
                    System.out.print("Tiene limite de horas? (S/N): ");
                    scanner.nextLine();
                    String opHoras = scanner.nextLine();
                    Integer limiteHoras = null;
                    if (opHoras.equalsIgnoreCase("S")) {
                        System.out.print("Cantidad de horas: ");
                        limiteHoras = scanner.nextInt();
                        scanner.nextLine();
                    }
                    System.out.print("Incluye anuncios? (true/false): ");
                    boolean conAnuncios = scanner.nextBoolean();
                    System.out.print("Numero de perfiles permitidos: ");
                    int perfiles = scanner.nextInt();
                    System.out.print("Permite descargas offline? (true/false): ");
                    boolean descargas = scanner.nextBoolean();
                    scanner.nextLine();

                    planDB.guardar(nomPlan, precio, limiteHoras, conAnuncios, perfiles, descargas);
                    break;

                case 8:
                    System.out.print("ID Usuario (DB): ");
                    int usrId = scanner.nextInt();
                    System.out.print("ID Plan (DB): ");
                    int planId = scanner.nextInt();
                    System.out.print("Duracion de la suscripcion en meses: ");
                    int meses = scanner.nextInt();
                    scanner.nextLine();

                    LocalDate inicio = LocalDate.now();
                    LocalDate fin = inicio.plusMonths(meses);

                    suscripcionDB.guardar(usrId, planId, inicio, fin);
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        }
        scanner.close();
    }
}