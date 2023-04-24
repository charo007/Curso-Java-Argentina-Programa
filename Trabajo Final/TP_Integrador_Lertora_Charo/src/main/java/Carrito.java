import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Carrito {

    Scanner dato = new Scanner(System.in);

    Main sistema;
    private List<Producto> itemsCarrito;

    private double descuentoARealizar;

    private double precioCompra;

   public Carrito() {
       sistema = new Main();

       itemsCarrito  = new ArrayList<>();
       this.descuentoARealizar = 0.0;
   }


    public void calcularDescuento(double totalAPagar) {

        this.descuentoARealizar = totalAPagar*0.20;
        System.out.println("Se le aplicará un descuento por su compra, el cual es de: $" + this.descuentoARealizar);
        System.out.println("El precio final es: $" + (totalAPagar - this.descuentoARealizar));
    }
    public void cargarCarrito() {

        int i = 0;
        String respuesta = " ";
        System.out.println("Desea cargar un producto?: si/no ");
        respuesta = dato.next();

        while (i < 3 && respuesta.equals("si")) {

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
            nuevoProducto.agregarProductoATabla(cantidad, precioUnitario, nombre, IDproducto);
            i++;


            System.out.println("Desea cargar otro producto?: si/no ");
            respuesta = dato.next();
        }
    }

    public void precio() {

        cargarCarrito();
        int IDcompra = 0;
        double total = 0;
        for (Producto producto : itemsCarrito) {
            total += producto.precioTotal();

            IDcompra += producto.getIDproducto();
        }
        if (total > 1000) {
            calcularDescuento(total);
            total -= this.descuentoARealizar;
        }

        this.precioCompra = total;
        String sql = "insert into compra (IDcompra, precioCompra, descuentoCompra) values ('"+ IDcompra +"','"+ precioCompra +"','"+ this.descuentoARealizar + "')";
        sistema.agregarEnTabla(sql);
    }


}
