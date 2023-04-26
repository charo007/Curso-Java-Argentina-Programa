import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producto {

        private int IDproducto;
        private int cantidad;
        private double precioUnitario;
        private String nombre;

        private int IDcompra;

        private Connection conexion;
        private Statement sentencia;

        Scanner dato = new Scanner(System.in);

        Producto() {

        }
        public Producto(int cantidad, double precioUnitario, String nombre, int IDproducto) {

                this.cantidad = cantidad;
                this.precioUnitario = precioUnitario;
                this.nombre = nombre;
                this.IDproducto = IDproducto;
        }

        public int getIDproducto() {
                return this.IDproducto;
        }

        public double precioTotal() {
                return cantidad*precioUnitario;
        }

        public void agregarProductoATabla(int cantidad, double precioUnitario, String nombre, int IDproducto, int IDcompra) {

                String sql = "insert into producto (IDprod, NombreProd, CantProd, PrecioUnitProd, IDcompra) values ('"+IDproducto+"','"+ nombre + "','" +  cantidad + "','" + precioUnitario + "','" + IDcompra + "')";
                 this.conexion = null;

                try {
                        conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrito", "root", "Charito1711");
                        sentencia= conexion.createStatement();

                        int introduccion_sql = sentencia.executeUpdate(sql);

                        if(introduccion_sql == 1) {
                                System.out.println("\t - SE REALIZÓ CORRECTAMENTE LA INSERCIÓN: " + sql);
                        } else {
                                System.out.println("\t - FALLÓ LA INSERCIÓN." );
                        }

                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        public void mostrarTablaProducto() {

                ResultSet resultado = buscar("select IDprod, NombreProd, CantProd, PrecioUnitProd from producto");

                try {
                        System.out.println("\t - LOS PRODUCTOS REGISTRADOS SON: ");

                        while (resultado.next()) {
                                System.out.println(resultado.getInt("IDprod") + " | " + resultado.getString("NombreProd" + " | " + resultado.getInt("CantProd") + " | " + resultado.getDouble("PrecioUnitProd") + " | "));
                        }

                } catch (SQLException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        private ResultSet buscar(String sql) {

                try {
                        conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrito", "root", "Charito1711");
                        sentencia = this.conexion.createStatement();

                        return sentencia.executeQuery(sql);
                } catch (SQLException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        return null;
                }
        }
}
