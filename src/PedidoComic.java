import java.util.ArrayList;

public class PedidoComic {

    int id;
    String usuario;  // nombre o mail del usuario logueado
    ArrayList<Comic> comicsComprados;
    double total;

    public PedidoComic(int idPedido, String usuarioPedido){
        id = idPedido;
        usuario = usuarioPedido;
        comicsComprados = new ArrayList<>();
        total = 0;

    }
}
/* Método posible para ver el pedido ,falta probarlo
public void mostrarPedido() {
    System.out.println("===================================");
    System.out.println("🧾 Pedido N°: " + id);
    System.out.println("👤 Usuario: " + usuario);
    System.out.println("📚 Cómics en el pedido:");
    for (Comic c : comicsComprados) {
        System.out.println("- " + c.nombre);
    }
    System.out.println("💰 Total: $" + total);
    System.out.println("===================================");
}
}*/