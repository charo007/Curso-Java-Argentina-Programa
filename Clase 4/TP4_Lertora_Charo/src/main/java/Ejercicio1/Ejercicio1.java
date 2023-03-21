package Ejercicio1;

import java.util.Scanner;
public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in); {

            System.out.println("Ingrese nu mombre: ");
            String nombre = lectura.next();

            System.out.println("Ingrese su apellido: ");
            String apellido = lectura.next();

            System.out.println("Ingrese su edad: ");
            int edad = lectura.nextInt();

            System.out.println("El usuario ingresó los siguientes datos: ");
            System.out.println("Nombre y apellido: " + nombre + " " + apellido + "\nEdad: " + edad);
        }
    }
}
