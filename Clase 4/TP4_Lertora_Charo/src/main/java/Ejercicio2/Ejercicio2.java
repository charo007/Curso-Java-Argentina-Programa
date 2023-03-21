package Ejercicio2;

public class Ejercicio2 {
    public static void main(String[] args) {

        Usuario persona = new Usuario();

        System.out.println("El usuario ingresó los siguientes datos: ");
        System.out.println("Nombre y apellido: " + persona.nombre + " " + persona.apellido + "\nEdad: " + persona.edad);

        if (persona.edad < 18) {
            System.out.println("\t-- Es menor de edad. --");
        } else {
            System.out.println("\t-- Es mayor de edad. --");
        }
    }
}
