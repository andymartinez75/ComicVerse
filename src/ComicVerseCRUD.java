
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ComicVerseCRUD {

    public static void main(String[] args) {

        ArrayList<Comic> comicsDB = obtenerComics();

        Scanner entrada = new Scanner(System.in);
        int idSiguiente = comicsDB.size() + 1;
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
            System.out.println("6. 🛒 Crear Pedido de Comics");
            System.out.println("7. 📦 Listar Pedidos de Comics");
            System.out.println("0. 🚪 Salir");
            System.out.print("\nSeleccione una opción: ");

            //Lee opcion y limpia el buffer
            opcionUsuario = entrada.nextInt();
            entrada.nextLine();

            switch (opcionUsuario) {
                case 1 -> {
                    crearComic(idSiguiente, comicsDB, entrada);
                    idSiguiente += 1;
                }
                case 2 -> listarComics(comicsDB);
                case 3 -> buscarComicsPorNombre(comicsDB, entrada);
                case 4 -> editarComic(comicsDB, entrada);
                case 5 -> borrarComic(comicsDB, entrada);
                case 6 -> enConstruccion("Crear Pedido");
                case 7 -> enConstruccion("Listar Pedidos");
                case 0 -> System.out.println("👋 ¡Gracias por usar ComicVerse CRUD!");
                default -> System.out.println("⚠️ Opción inválida, intente nuevamente.");
            }
        } while (opcionUsuario != 0);


    }

    //Funciones Principales temporales con string

    public static void crearComic(int id, ArrayList<Comic> comics, Scanner entrada) {

        System.out.println("Creando Nuevo Comic");
        System.out.print("Ingrese el nombre del comic: ");
        String nombre = entrada.nextLine();

        if (nombre.trim().isEmpty()) {
            System.out.println("⚠️ No puede ingresar un nombre vacío.");
            return;
        }

        comics.add(new Comic(id, nombre));
        System.out.println("📖 Nuevo cómic creado con éxito!");
    }

    public static void listarComics(ArrayList<Comic> comics) {
        System.out.println("=======================================");
        System.out.println("       📚 LISTA DE COMICS ");
        System.out.println("=======================================");

        if (comics == null || comics.isEmpty()) {
            System.out.println("⚠️  No hay comics para mostrar.");
        } else {
            for (Comic comic : comics) {
                System.out.printf(" %2d. %s%n", comic.id, comic.nombre);
            }
        }
        System.out.println("📚 Mostrando lista de cómics...");
    }

    public static void buscarComicsPorNombre(ArrayList<Comic> comics, Scanner entrada) {

        System.out.println("Ingrese el comic a buscar: ");
        String busqueda = entrada.nextLine();
        ArrayList<Comic> comicsEncontrados = new ArrayList<>();

        for (Comic comic : comics) {
            if (estaIncluido(comic.nombre, busqueda)) {
                comicsEncontrados.add(comic);
            }
        }
        if (comicsEncontrados.isEmpty()) {
            System.out.println("⚠️ No se encontraron cómics que coincidan con la búsqueda: '" + busqueda + "'.");
        } else {
            listarComics(comicsEncontrados);
            System.out.println("🔎 Cómics encontrados...");
        }

    }

    public static void editarComic(List<Comic> comics, Scanner entrada) {

        Comic comic = obtenerIdComic(comics, entrada);
        if (comic == null) return;
        String comicOriginal = comic.nombre;
        System.out.println("Comic a editar: " + comicOriginal);
        System.out.println("Ingrese el nuevo nombre del comic: ");
        String nuevoNombre = entrada.nextLine();

        comic.nombre = nuevoNombre;
        System.out.println("✏️ 🛠️ Actualizando cómic...");
        System.out.printf("El nombre del comic cambio de %s a %s ", comicOriginal, nuevoNombre);
        System.out.println();


    }

    public static void borrarComic(List<Comic> comics, Scanner entrada) {

        Comic comic = obtenerIdComic(comics, entrada);
        if (comic == null) return;

        String comicOriginal = comic.nombre;
        System.out.println("Comic a borrar: " + comicOriginal);
        System.out.print("¿Confirma que desea eliminarlo? (s/n): ");
        String confirmacion = entrada.nextLine();
        if (confirmacion.equalsIgnoreCase("s")) {
            comics.remove(comic);
            System.out.printf("🗑️ El cómic '%s' fue eliminado.%n", comicOriginal);
        } else {
            System.out.println("❎ Eliminación cancelada.");
        }
    }

    //=============== DATOS INICIALES COMICS ===============

    public static ArrayList<Comic> obtenerComics() {
        ArrayList<Comic> comics = new ArrayList<>();

        comics.add(new Comic(1, "Batman: The Killing Joke"));
        comics.add(new Comic(2, "Spider-Man: Into the Spider-Verse"));
        comics.add(new Comic(3, "X-Men: Dark Phoenix Saga"));
        comics.add(new Comic(4, "Superman: Red Son"));
        comics.add(new Comic(5, "Wonder Woman: Blood"));
        comics.add(new Comic(6, "The Flash: Rebirth"));
        comics.add(new Comic(7, "Avengers: Infinity Gauntlet"));
        comics.add(new Comic(8, "Iron Man: Extremis"));
        comics.add(new Comic(9, "Deadpool: Secret Invasion"));
        comics.add(new Comic(10, "Doctor Strange: The Oath"));

        return comics;
    }

//================== UTILIDADES ==================

    public static void enConstruccion(String nombreFuncion) {
        System.out.println("🔧 La opción '" + nombreFuncion + "' está en desarrollo. ¡Próximamente disponible!");
    }

    public static boolean estaIncluido(String nombreCompleto, String nombreParcial) {

        return formatoBusqueda(nombreCompleto).contains(formatoBusqueda(nombreParcial));
    }

    public static String formatoBusqueda(String texto) {
        return texto.trim().toLowerCase();
    }

    public static Comic obtenerIdComic(List<Comic> comics, Scanner entrada) {

        System.out.print("Ingrese el id del cómic: ");
        int idBusqueda = entrada.nextInt();
        entrada.nextLine();

        for (Comic comic : comics) {
            if (comic.id == idBusqueda) {
                return comic;
            }
        }
        System.out.println("⚠️ No se encontró ningún cómic con ese nombre.");
        return null;
    }
}





