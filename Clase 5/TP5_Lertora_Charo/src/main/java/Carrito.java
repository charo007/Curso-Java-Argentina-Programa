import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Carrito {

    Scanner dato = new Scanner(System.in);
    private List<Producto> itemsCarrito;

    private double descuentoARealizar;

   public Carrito() {
       itemsCarrito  = new ArrayList<>();
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
            System.out.println("Ingrese el nombre del producto: ");
            String nombre = dato.next();

            System.out.println("Ingrese la cantidad que lleva del mismo producto: ");
            int cantidad = dato.nextInt();

            System.out.println("Ingrese el precio unitario: ");
            double precioUnitario = dato.nextDouble();

            itemsCarrito.add(new Producto(cantidad, precioUnitario, nombre));
            i++;

            System.out.println("Desea cargar otro producto?: si/no ");
            respuesta = dato.next();
        }
    }

    public double precio() {

        cargarCarrito();

        double total = 0;
        for (Producto producto : itemsCarrito) {
            total += producto.precioTotal();
        }

        if (total > 1000) {
            calcularDescuento(total);
            total -= this.descuentoARealizar;
        }
        return total;
    }


}
