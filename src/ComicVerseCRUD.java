//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.Scanner;

public class ComicVerseCRUD {

    public static void main(String[] args) {

        ArrayList<String> comicsDB = obtenerComics();

        Scanner entrada = new Scanner(System.in);
        int opcionUsuario;

        do {
            System.out.println();
            System.out.println("🚀 Bienvenido a ComicVerse CRUD 🚀");
            System.out.println("---------------------------------");
            System.out.println("1. ✨ ➕ Crear cómic");
            System.out.println("2. 📚 🔍 Listar cómics");
            System.out.println("3. 🔎 Buscar cómic por nombre");
            System.out.println("4. ✏️ 🛠️ Actualizar cómic");
            System.out.println("5. 🗑️ ❌ Eliminar cómic");
            System.out.println("0. 🚪 Salir");
            System.out.print("\nSeleccione una opción: ");

            opcionUsuario = entrada.nextInt();

            switch (opcionUsuario) {
                case 1:
                    crearComic(comicsDB);
                    System.out.println("📖 Nuevo cómic creado con éxito!");
                    break;
                case 2:
                    listarComics(comicsDB);
                    System.out.println("📚 Mostrando lista de cómics...");
                    break;
                case 3:
                    buscarComicsPorNombre(comicsDB);
                    System.out.println(" 🔎 Cómics encontrados...");
                    break;
                case 4:
                    System.out.println("✏️ 🛠️ Actualizando cómic...");
                    break;
                case 5:
                    System.out.println("🗑️ Cómic eliminado.");
                    break;
                case 0:
                    System.out.println("👋 ¡Gracias por usar ComicVerse CRUD!");
                    break;
                default:
                    System.out.println("⚠️ Opción inválida, intente nuevamente.");
            }
        } while (opcionUsuario != 0);

        entrada.close();
    }

   //Funciones

    public static void crearComic(ArrayList<String> comics) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Creando Nuevo Comic");
        System.out.print("Ingrese el nombre del comic: ");
        String nombreComic = entrada.nextLine();

        comics.add(nombreComic);
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
    }
    public static void buscarComicsPorNombre(ArrayList<String> comics) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el comic a buscar: ");
        String busqueda = entrada.nextLine();
        ArrayList<String> comicsEncontrados = new ArrayList<>();

        for (String comic : comics) {
            if (estaIncluido(comic, busqueda)) {
                comicsEncontrados.add(comic);
            }
        }

        listarComics(comicsEncontrados);
    }




    public static ArrayList<String> obtenerComics() {
        ArrayList<String> comics = new ArrayList<>();

        // Algunos cómics de tu frontend (comic_verse) + extra de prueba
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
//Utilidades

    public static boolean estaIncluido(String nombreCompleto, String nombreParcial) {
        String nombreCompletoFormateado = formatoBusqueda(nombreCompleto);

        return nombreCompletoFormateado.contains(formatoBusqueda(nombreParcial));
    }

    public static String formatoBusqueda(String texto) {
        return texto.trim().toLowerCase();
    }

}
