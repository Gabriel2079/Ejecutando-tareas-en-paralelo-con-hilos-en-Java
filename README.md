# PRY2203 - Desarrollo Orientado a Objetos II
## Semana 4: Ejecutando tareas en paralelo con hilos en Java
### Caso: Optimización de entregas en SpeedFast

---

## 📌 Descripción del Proyecto
Este proyecto corresponde a la actividad formativa de la Semana 4 para la asignatura **Desarrollo Orientado a Objetos II** (Duoc UC). Se amplía el sistema de entregas de la empresa **SpeedFast**, implementando programación concurrente y multihilo en Java para simular el despacho simultáneo de pedidos a través de múltiples repartidores.

---

## 🚀 Requerimientos Implementados

1. **Estructura Orientada a Objetos:**
   * **Clase Base:** `Pedido` (atributos: idPedido, direccionEntrega, distanciaKm; métodos de cálculo y resumen).
   * **Subclases Especializadas:** `PedidoComida`, `PedidoEncomienda` y `PedidoExpress`, con lógica particular de cálculo de tiempos.
   * **Interfaces:** `Despachable`, `Cancelable` y `Rastreable` (incorporando la trazabilidad y bitácora de eventos).

2. **Programación Concurrente con Hilos:**
   * **Clase `Repartidor`:** Implementa la interfaz `Runnable`.
   * **Simulación Realista:** Cada repartidor recorre su lista secuencialmente usando `Thread.sleep()` con pausas aleatorias para simular el tiempo de entrega en ruta.
   * **Gestor de Hilos:** Uso de `ExecutorService` en la clase `Main` para orquestar la ejecución en paralelo de al menos 3 repartidores independientes.
   * **Cierre Controlado:** Coordinación y espera activa hasta que todos los repartidores concluyen todas sus entregas asignadas.

---

## 📂 Estructura del Proyecto

```text
src/
└── cl/
    └── speedfast/
        ├── interfaces/
        │   ├── Cancelable.java
        │   ├── Despachable.java
        │   └── Rastreable.java
        ├── model/
        │   ├── Pedido.java
        │   ├── PedidoComida.java
        │   ├── PedidoEncomienda.java
        │   ├── PedidoExpress.java
        │   └── Repartidor.java
        └── main/
            └── Main.java
