import java.util.ArrayList;
import java.util.List;

public abstract class Pedido implements Despachable, Cancelable, Rastreable {
    protected int idPedido;
    protected String direccionEntrega;
    protected double distanciaKm;
    protected String estado;

    // Registro de eventos
    private final List<String> historial = new ArrayList<>();

    public Pedido(int idPedido, String direccionEntrega, double distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
        this.estado = "Creado";
        this.historial.add("Pedido creado con estado inicial: " + this.estado);
    }

    public abstract double calcularTiempoEntrega();

    public void mostrarResumen() {
        System.out.println("ID: #" + idPedido +
                " | Tipo: " + this.getClass().getSimpleName() +
                " | Dirección: " + direccionEntrega +
                " | Distancia: " + distanciaKm + " km" +
                " | Estado actual: " + estado);
    }

    @Override
    public void despachar() {
        this.estado = "En camino";
        this.historial.add("Pedido despachado - Estado: En camino");
    }

    @Override
    public void cancelar() {
        this.estado = "Cancelado";
        this.historial.add("Pedido cancelado - Estado: Cancelado");
    }

    public void entregar() {
        this.estado = "Entregado";
        this.historial.add("Pedido entregado al cliente con éxito");
    }

    @Override
    public void verHistorial() {
        System.out.println("=== Historial del Pedido #" + idPedido + " ===");
        historial.forEach(System.out::println);
    }

    public int getIdPedido() {
        return idPedido;
    }

    public String getEstado() {
        return estado;
    }
}