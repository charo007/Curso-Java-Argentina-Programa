import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private Connection conexion;
    private Statement sentencia;
    public static void main(String[] args) {
        Carrito carritoSuper = new Carrito();
        Main sistema = new Main();

        boolean salir = false;

        carritoSuper.precio();
        System.out.println("Bienvenido a nuestro Supermercado!");


        System.out.println("Gracias! Vuelva pronto :D");
    }

    public void conectar_BD() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrito", "root", "Charito1711");

        } catch (Exception e) {
            System.out.println("\t - NO SE HA PODIDO REALIZAR LA CONEXIÓN -");
            System.out.println("\t ----------------------------------------");
        }
    }

    private void desconectar_BD() {
        try {
            conexion.close();

            System.out.println("\t - CONEXIÓN FINALIZADA CORRECTAMENTE -");
            System.out.println("\t ------------------------------------");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void agregarEnTabla(String sql) {

        try {
            conectar_BD();
            sentencia = this.conexion.createStatement();

            int introduccion_sql = sentencia.executeUpdate(sql);

            if(introduccion_sql == 1) {
                System.out.println("\t - SE REALIZÓ CORRECTAMENTE LA INSERCIÓN: " + sql);
            } else {
                System.out.println("\t - FALLÓ LA INSERCIÓN." );
            }
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
