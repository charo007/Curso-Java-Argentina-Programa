import java.util.ArrayList;
import java.util.InputMismatchException;
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
        boolean continua;

        do {
            try {
                continua = false;
                System.out.println("Desea cargar un producto?: si/no ");
                respuesta = dato.next();

            } catch (InputMismatchException ex) {
                System.out.println("Debe ingresar obligatoriamente una plabra sin números.");
                dato.next();
                continua = true;
            }
        } while (continua);

        while (i < 3 && respuesta.equals("si")) {
            String nombre = " ";
            int cantidad = 0;
            double precioUnitario = 0.0;

            do {
               try {
                   continua = false;
                   System.out.println("Ingrese el nombre del producto: ");
                   nombre = dato.next();
               } catch (InputMismatchException ex) {
                   System.out.println("Debe ingresar obligatoriamente una plabra sin números.");
                   dato.next();
                   continua = true;
               }
            } while (continua);

            do {
                try {
                    continua = false;
                    System.out.println("Ingrese la cantidad que lleva del mismo producto: ");
                    cantidad = dato.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("Debe ingresar obligatoriamente un número entero.");
                    dato.next();
                    continua = true;
                }
            } while (continua);

            do {
                try {
                    continua = false;
                    System.out.println("Ingrese el precio unitario: ");
                    precioUnitario = dato.nextDouble();
                } catch (InputMismatchException ex) {
                    System.out.println("Debe ingresar obligatoriamente un número decimal.");
                    dato.next();
                    continua = true;
                }
            } while (continua);

            itemsCarrito.add(new Producto(cantidad, precioUnitario, nombre));
            i++;

            do {
                try {
                    continua = false;
                    System.out.println("Desea cargar otro producto?: si/no ");
                    respuesta = dato.next();

                } catch (InputMismatchException ex) {
                    System.out.println("Debe ingresar obligatoriamente una plabra sin números.");
                    dato.next();
                    continua = true;
                }
            } while (continua);

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
