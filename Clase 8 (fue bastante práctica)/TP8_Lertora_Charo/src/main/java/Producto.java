
public class Producto {

        private int cantidad;
        private double precioUnitario;
        private String nombre;

        public Producto(int cantidad, double precioUnitario, String nombre) {
                this.cantidad = cantidad;
                this.precioUnitario = precioUnitario;
                this.nombre = nombre;
        }

        public double precioTotal() {
                return cantidad*precioUnitario;
        }
}
