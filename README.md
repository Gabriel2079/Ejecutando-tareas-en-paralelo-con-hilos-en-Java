- Desarrollo Orientado a Objetos II
## Semana 4: Tareas en paralelo con hilos en Java
### Proyecto: Simulación de repartos SpeedFast

---

## 📌 ¿De qué trata este proyecto?
Este trabajo es para la Semana 4 del ramo en Duoc UC. Aquí mejoré el sistema de entregas para la empresa **SpeedFast**, usando hilos en Java para simular que varios repartidores entregan pedidos al mismo tiempo.

---

## 🚀 Lo que hace el programa

1. **Clases y tipos de pedidos:**
   * **Clase padre (`Pedido`):** Guarda los datos generales como el código del pedido, la dirección y la distancia en km.
   * **Tipos de entrega:** Creé clases para cada caso (`PedidoComida`, `PedidoEncomienda` y `PedidoExpress`), cada una calculando el tiempo según sus propias reglas.
   * **Interfaces:** Usé `Despachable`, `Cancelable` y `Rastreable` para poder guardar el historial de estados de cada pedido.

2. **Uso de hilos y repartidores:**
   * **Repartidores (`Runnable`):** Cada repartidor tiene su nombre y su propia lista de pedidos.
   * **Simulación con pausas:** El método `run()` va entregando pedido por pedido y usa una pausa aleatoria (`Thread.sleep`) para simular lo que demora el viaje.
   * **Trabajo en paralelo:** En el `Main` usé `ExecutorService` para que los 3 repartidores (Camila, Andrés y Luis) salgan a la calle al mismo tiempo.
   * **Cierre ordenado:** El programa espera a que todos terminen de entregar antes de cerrar y muestra la bitácora final en la pantalla.

---

## 📂 Estructura de las carpetas

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
