import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Carrito {

    Scanner dato = new Scanner(System.in);

    private List<Producto> itemsCarrito;

    private double descuentoARealizar;

    private double precioCompra;

    private int IDcompra;

    private Connection conexion;
    private Statement sentencia;

   public Carrito() {

       itemsCarrito  = new ArrayList<>();
       this.descuentoARealizar = 0.0;
       this.precioCompra = 0.0;
       this.IDcompra = 0;
   }


    public void calcularDescuento(double totalAPagar) {

        this.descuentoARealizar = totalAPagar*0.20;
        System.out.println("Se le aplicará un descuento por su compra, el cual es de: $" + this.descuentoARealizar);
        System.out.println("El precio final es: $" + (totalAPagar - this.descuentoARealizar));
    }
    public void cargarCarrito() {

        String respuesta = " ";
        System.out.println("Desea cargar un producto?: si/no ");
        respuesta = dato.next();
        System.out.println("Ingrese el nro de compra : ");

        this.IDcompra = dato.nextInt();
        String sql = "insert into compra (IDcompra) values ('"+ IDcompra + "')";
        conexion = null;

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrito", "root", "Charito1711");
            sentencia = conexion.createStatement();

            int introduccion_sql = sentencia.executeUpdate(sql);

            if(introduccion_sql == 1) {
                System.out.println("\t - SE REALIZÓ CORRECTAMENTE LA INSERCIÓN: " + sql);
            } else {
                System.out.println("\t - FALLÓ LA INSERCIÓN." );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        while (respuesta.equals("si")) {

            System.out.println("Ingrese el ID del producto: ");
            int IDproducto = dato.nextInt();

            System.out.println("Ingrese el nombre del producto: ");
            String nombre = dato.next();

            System.out.println("Ingrese la cantidad que lleva del mismo producto: ");
            int cantidad = dato.nextInt();

            System.out.println("Ingrese el precio unitario: ");
            double precioUnitario = dato.nextDouble();


            Producto nuevoProducto = new Producto(cantidad, precioUnitario, nombre, IDproducto);
            itemsCarrito.add(nuevoProducto);
            nuevoProducto.agregarProductoATabla(cantidad, precioUnitario, nombre, IDproducto, IDcompra);

            System.out.println("Desea cargar otro producto?: si/no ");
            respuesta = dato.next();
        }
    }

    public void precio() {

        cargarCarrito();
        double total = 0;
        for (Producto producto : itemsCarrito) {
            total += producto.precioTotal();

        }
        if (total > 1000) {
            calcularDescuento(total);
            total -= this.descuentoARealizar;
        }

        this.precioCompra = total;
        agregarCompraATabla();

    }

    public void agregarCompraATabla() {

        String sql = "insert into compra (precioCompra, descuentoCompra) values ('"+ precioCompra +"','"+ this.descuentoARealizar + "') where IDcompra = " + this.IDcompra + ";";
        conexion = null;

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrito", "root", "Charito1711");
            sentencia = conexion.createStatement();

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


    public void mostrarTablaCompra() {

        ResultSet resultado = buscar("select * from compra");

        try {
            System.out.println("\t - LAS COMPRAS REGISTRADAS SON: ");

            while (resultado.next()) {
                System.out.println(resultado.getBigDecimal("descuentoCompra") + " | " + resultado.getInt("IDcompra" + " | " + resultado.getBigDecimal("precioCompra") + " | "));
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
