import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO SIMULACIÓN SPEEDFAST ===\n");

        // Repartidor 1: 2 pedidos asignados
        List<Pedido> pedidosCamila = new ArrayList<>();
        pedidosCamila.add(new PedidoComida(101, "Av. Providencia 1234", 3.5, 20));
        pedidosCamila.add(new PedidoExpress(102, "Calle Las Flores 456", 5.0, true));
        Repartidor r1 = new Repartidor("Camila", pedidosCamila);

        // Repartidor 2: 2 pedidos asignados
        List<Pedido> pedidosLuis = new ArrayList<>();
        pedidosLuis.add(new PedidoEncomienda(201, "Los Conquistadores 890", 12.0, 4.5));
        pedidosLuis.add(new PedidoComida(202, "Av. Apoquindo 3000", 2.2, 15));
        Repartidor r2 = new Repartidor("Luis", pedidosLuis);

        // Repartidor 3: 2 pedidos asignados
        List<Pedido> pedidosAndres = new ArrayList<>();
        pedidosAndres.add(new PedidoExpress(301, "San Martín 780", 6.8, false));
        pedidosAndres.add(new PedidoEncomienda(302, "Manuel Montt 110", 8.4, 2.0));
        Repartidor r3 = new Repartidor("Andrés", pedidosAndres);

        // Ejecutar varias tareas al mismo tiempo
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(r1);
        executor.execute(r2);
        executor.execute(r3);

        // Finalizar y cerrar las tareas
        executor.shutdown();

        try {
            // Espera que terminen las tareas (máximo 60 seg)
            if (executor.awaitTermination(60, TimeUnit.SECONDS)) {
                System.out.println("\n=== TODAS LAS ENTREGAS HAN SIDO COMPLETADAS CON ÉXITO ===");
            } else {
                System.out.println("\nEl tiempo de espera expiró antes de finalizar.");
            }
        } catch (InterruptedException e) {
            System.err.println("La simulación fue interrumpida: " + e.getMessage());
            Thread.currentThread().interrupt();
        }

        // Mostrar el historial del pedido
        System.out.println("\n--- Demostración de Rastreabilidad (Bitácora) ---");
        pedidosCamila.get(0).verHistorial();
        pedidosLuis.get(0).verHistorial();
    }
}