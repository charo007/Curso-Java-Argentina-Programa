import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    Connection conexion;
    Statement sentencia;

    static Scanner dato = new Scanner(System.in);
    public static void main(String[] args) {
        Carrito carritoSuper = new Carrito();
        Producto productos = new Producto();

        String respuesta = " ";

        do {
            System.out.println("Bienvenido a nuestro Supermercado!");
            carritoSuper.precio();

            System.out.println("Desea llenar otro carrito?: si/no");
            respuesta = dato.next();

        } while (respuesta.equals("si"));

        //carritoSuper.mostrarTablaCompra();
        //productos.mostrarTablaProducto();

        System.out.println("Gracias! Vuelva pronto :D");
    }

}
