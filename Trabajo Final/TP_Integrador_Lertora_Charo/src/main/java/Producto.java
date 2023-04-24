import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Producto {

        Main sistema;
        private int IDproducto;
        private int cantidad;
        private double precioUnitario;
        private String nombre;

        Scanner dato = new Scanner(System.in);

        public Producto(int cantidad, double precioUnitario, String nombre, int IDproducto) {
                sistema = new Main();
                this.cantidad = cantidad;
                this.precioUnitario = precioUnitario;
                this.nombre = nombre;
                this.IDproducto = IDproducto;
        }

        public double precioTotal() {
                return cantidad*precioUnitario;
        }

        public void agregarProductoATabla(int cantidad, double precioUnitario, String nombre, int IDproducto) {

                String sql = "insert into producto (IDprod, NombreProd, CantProd, PrecioUnitProd) values ('"+IDproducto+"','"+ nombre + "','" +  cantidad + "','" + precioUnitario + "')";
                this.sistema.agregarEnTabla(sql);

        }
}
