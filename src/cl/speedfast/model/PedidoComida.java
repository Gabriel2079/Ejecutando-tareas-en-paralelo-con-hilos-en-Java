public class PedidoComida extends Pedido {
    private double tiempoCoccionMin;

    public PedidoComida(int idPedido, String direccionEntrega, double distanciaKm, double tiempoCoccionMin) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.tiempoCoccionMin = tiempoCoccionMin;
    }

    @Override
    public double calcularTiempoEntrega() {
        // Tiempo total: cocción + 3 min por km
        return tiempoCoccionMin + (distanciaKm * 3);
    }
}