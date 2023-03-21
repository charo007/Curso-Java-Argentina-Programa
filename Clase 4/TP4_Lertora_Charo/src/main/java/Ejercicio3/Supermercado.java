package Ejercicio3;

import java.util.Scanner;

public class Supermercado {

    Scanner dato = new Scanner(System.in);

    public void compraProducto() {

        System.out.println("Ingrese el nombre del producto: ");
        String nombreProducto = dato.next();

        System.out.println("Ingrese el precio del producto: ");
        double precio = dato.nextDouble();

        System.out.println("Ingrese la cantidad: ");
        int cantidadProductos = dato.nextInt();

        double total = precio * cantidadProductos;
        System.out.println("El total hasta ahora es: " + total);

        double totalFinal = total;
        double descuento = total*0.20;

        if(total > 1000) {
            System.out.println("Se le aplicará un descuento por su compra, el cual es de: $" + descuento);
            totalFinal = total - descuento;
            System.out.println("El precio final es: $" + totalFinal);
        } else {
            System.out.println("Usted no tiene descuentos, por lo tanto deberá abonar: $" + totalFinal);
        }
    }

    public void Seccion() {
        String nombreCliente;
        System.out.println("Ingrese el nombre del cliente: ");
        nombreCliente = dato.next();

        System.out.println("Ingrese el nombre de la sección de productos, siendo las opciones: " + "\n\tFrutas" + "\n\tLacteos" + "\n\tGaseosas");
        String nombreSeccion = dato.next();

        switch (nombreSeccion) {
            case "frutas": compraProducto(); break;
            case "lacteos": compraProducto(); break;
            case "gaseosas": compraProducto(); break;
        }
    }
}
