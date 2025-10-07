
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ComicVerseCRUD {

    public static void main(String[] args) {

        ArrayList<String> comicsDB = obtenerComics();

        Scanner entrada = new Scanner(System.in);
        int opcionUsuario;

        do {
            System.out.println("---------------------------------");
            System.out.println("🚀 Bienvenido a ComicVerse CRUD 🚀");
            System.out.println("---------------------------------");
            System.out.println("1. ✨ ➕ Crear cómic");
            System.out.println("2. 📚 🔍 Listar cómics");
            System.out.println("3. 🔎 Buscar cómic por nombre");
            System.out.println("4. ✏️ 🛠️ Actualizar cómic");
            System.out.println("5. 🗑️ ❌ Eliminar cómic");
            System.out.println("0. 🚪 Salir");
            System.out.print("\nSeleccione una opción: ");

            //Lee opcion y limpia el buffer
            opcionUsuario = entrada.nextInt();
            entrada.nextLine();

            switch (opcionUsuario) {
                case 1 -> crearComic(comicsDB,entrada);
                case 2 -> listarComics(comicsDB);
                case 3 -> buscarComicsPorNombre(comicsDB,entrada);
                case 4 -> editarComic(comicsDB,entrada);
                case 5 -> borrarComic(comicsDB,entrada);
                case 0 -> System.out.println("👋 ¡Gracias por usar ComicVerse CRUD!");
                default -> System.out.println("⚠️ Opción inválida, intente nuevamente.");
            }
        } while (opcionUsuario != 0);


    }

   //Funciones Principales temporales con string

    public static void crearComic(ArrayList<String> comics,Scanner entrada) {

        System.out.println("Creando Nuevo Comic");
        System.out.print("Ingrese el nombre del comic: ");
        String nombreComic = entrada.nextLine();

        if (nombreComic.trim().isEmpty()) {
            System.out.println("⚠️ No puede ingresar un nombre vacío.");
            return;
        }

        comics.add(nombreComic);
        System.out.println("📖 Nuevo cómic creado con éxito!");
    }
    public static void listarComics(ArrayList<String> comics) {
        System.out.println("=======================================");
        System.out.println("       📚 LISTA DE COMICS ");
        System.out.println("=======================================");

        if (comics == null || comics.isEmpty()) {
            System.out.println("⚠️  No hay comics para mostrar.");
        } else {
            int contador = 1;
            for (String comic : comics) {
                System.out.printf(" %2d. %s%n", contador++, comic);
            }
        }
        System.out.println("📚 Mostrando lista de cómics...");
    }
    public static void buscarComicsPorNombre(ArrayList<String> comics,Scanner entrada) {

        System.out.println("Ingrese el comic a buscar: ");
        String busqueda = entrada.nextLine();
        ArrayList<String> comicsEncontrados = new ArrayList<>();

        for (String comic : comics) {
            if (estaIncluido(comic, busqueda)) {
                comicsEncontrados.add(comic);
            }
        }

        listarComics(comicsEncontrados);
        System.out.println(" 🔎 Cómics encontrados...");
    }
    public static void editarComic(List<String> comics,Scanner entrada) {

        int indiceComic = obtenerIdComic(comics, entrada);

        if (indiceComic == -1) {
            System.out.println("❌ No se pudo editar: cómic no encontrado.");
            return;
        }
        String comicOriginal = comics.get(indiceComic);
        System.out.println("Comic a editar: "+comicOriginal);
        System.out.println("Ingrese el nuevo nombre del comic: ");
        String comicNuevo = entrada.nextLine();

        comics.set (indiceComic,comicNuevo);
        System.out.println("✏️ 🛠️ Actualizando cómic...");
        System.out.printf("El nombre del comic cambio de %s a %s ",comicOriginal,comicNuevo);


    }
    public static void borrarComic(List<String> comics,Scanner entrada) {

        int indiceComic = obtenerIdComic(comics,entrada);
        if (indiceComic == -1) {
            System.out.println("❌ No se pudo eliminar: cómic no encontrado.");
            return;
        }
        String comicOriginal = comics.get(indiceComic);
        System.out.println("Comic a borrar: "+comicOriginal);
        System.out.print("¿Confirma que desea eliminarlo? (s/n): ");
        String confirmacion = entrada.nextLine();
        if (confirmacion.equalsIgnoreCase("s")) {
            comics.remove(indiceComic);
            System.out.printf("🗑️ El cómic '%s' fue eliminado.%n", comicOriginal);
        } else {
            System.out.println("❎ Eliminación cancelada.");
        }
    }

    //=============== DATOS INICIALES COMICS ===============

    public static ArrayList<String> obtenerComics() {
        ArrayList<String> comics = new ArrayList<>();

        comics.add("Batman: The Killing Joke");
        comics.add("Spider-Man: Into the Spider-Verse");
        comics.add("X-Men: Dark Phoenix Saga");
        comics.add("Superman: Red Son");
        comics.add("Wonder Woman: Blood");
        comics.add("The Flash: Rebirth");
        comics.add("Avengers: Infinity Gauntlet");
        comics.add("Iron Man: Extremis");
        comics.add("Deadpool: Secret Invasion");
        comics.add("Doctor Strange: The Oath");

        return comics;
    }

//================== UTILIDADES ==================

    public static boolean estaIncluido(String nombreCompleto, String nombreParcial) {
        String nombreCompletoFormateado = formatoBusqueda(nombreCompleto);

        return nombreCompletoFormateado.contains(formatoBusqueda(nombreParcial));
    }

    public static String formatoBusqueda(String texto) {
        return texto.trim().toLowerCase();
    }

    public static int obtenerIdComic(List<String>comics,Scanner entrada){
        System.out.print("Ingrese el nombre del cómic: ");
        String busqueda = entrada.nextLine();

        for (String comic : comics) {
            if (estaIncluido(comic, busqueda)) {
                return comics.indexOf(comic);
            }
        }

        System.out.println("⚠️ No se encontró ningún cómic con ese nombre.");
        return -1;
        }
    }


