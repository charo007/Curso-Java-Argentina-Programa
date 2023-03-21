package Ejercicio2;

import java.util.Scanner;

public class Usuario {

    public String nombre;
    public String apellido;
    public int edad;
    Scanner lectura = new Scanner(System.in);

    public Usuario() {
        System.out.println("Ingrese nu mombre: ");
        this.nombre = lectura.next();

        System.out.println("Ingrese su apellido: ");
        this.apellido = lectura.next();

        System.out.println("Ingrese su edad: ");
        this.edad = lectura.nextInt();
    }
}
