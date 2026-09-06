public class PedidoEncomienda extends Pedido {
    private double pesoKg;

    public PedidoEncomienda(int idPedido, String direccionEntrega, double distanciaKm, double pesoKg) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.pesoKg = pesoKg;
    }

    @Override
    public double calcularTiempoEntrega() {
        // Tiempo total: 4 min por km + extra por peso
        return (distanciaKm * 4) + (pesoKg * 0.5);
    }
}