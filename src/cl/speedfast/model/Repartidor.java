import java.util.List;
import java.util.Random;

public class Repartidor implements Runnable {
    private String nombre;
    private List<Pedido> pedidos;
    private Random random = new Random();

    public Repartidor(String nombre, List<Pedido> pedidos) {
        this.nombre = nombre;
        this.pedidos = pedidos;
    }

    @Override
    public void run() {
        for (Pedido pedido : pedidos) {
            try {
                // Despacha y guarda el evento
                pedido.despachar();
                System.out.println("[Repartidor: " + nombre + "] Entregando "
                        + pedido.getClass().getSimpleName() + " #" + pedido.getIdPedido()
                        + " a: " + pedido.direccionEntrega + "...");

                // Pausa de 1.5 a 3.5 segundos para simular la entrega
                int tiempoSimulado = 1500 + random.nextInt(2000);
                Thread.sleep(tiempoSimulado);

                // Guarda la entrega y muestra el final
                pedido.entregar();
                System.out.println("[Repartidor: " + nombre + "] Pedido #"
                        + pedido.getIdPedido() + " entregado exitosamente.");

            } catch (InterruptedException e) {
                System.err.println("[Repartidor: " + nombre + "] Error en la entrega del pedido #"
                        + pedido.getIdPedido() + ": " + e.getMessage());
                Thread.currentThread().interrupt(); // Restablecer bandera de interrupción
                break;
            }
        }
        System.out.println("--> [Repartidor: " + nombre + "] Ha finalizado todas sus entregas asignadas.");
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}