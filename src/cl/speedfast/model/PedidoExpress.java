public class PedidoExpress extends Pedido {
    private boolean prioridadAlta;

    public PedidoExpress(int idPedido, String direccionEntrega, double distanciaKm, boolean prioridadAlta) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.prioridadAlta = prioridadAlta;
    }

    @Override
    public double calcularTiempoEntrega() {
        // Envío express: 2 min por km
        double base = distanciaKm * 2;
        return prioridadAlta ? base * 0.8 : base;
    }
}