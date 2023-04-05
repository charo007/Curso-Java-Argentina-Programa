import java.util.Scanner;
public class Calculadora {

    private double primerNumero;
    private double segundoNumero;

    private double sumar(double unNumero, double otroNumero) {
        return unNumero + otroNumero;
    }

    private double restar(double unNumero, double otroNumero) {
        return unNumero - otroNumero;
    }

    private double multiplicar(double unNumero, double otroNumero) {
        return unNumero * otroNumero;
    }

    private double dividir(double unNumero, double otroNumero) {
        return unNumero / otroNumero;
    }

    private void mostrarResultado(double resultado, String respuesta) {
        System.out.println("Los números con los que se realizó la operación " + respuesta + " son: " + this.primerNumero + " " + this.segundoNumero);
        System.out.println("El resultado final es: " + resultado);
    }

    public void usarCalculadora() {
        Scanner dato = new Scanner(System.in);

        System.out.println("Ingrese un número: ");
        this.primerNumero = dato.nextDouble();

        System.out.println("Ingrese el otro número: ");
        this.segundoNumero = dato.nextDouble();

        System.out.println("Qué operación desea realizar? sumar/restar/multiplicar/dividir");
        String respuesta = dato.next();

        double resultado = 0;

        switch (respuesta) {
            case "suma":
                resultado = sumar(primerNumero, segundoNumero);
                break;
            case "resta":
                resultado = restar(primerNumero, segundoNumero);
                break;
            case "multiplicar":
                resultado = multiplicar(primerNumero, segundoNumero);
                break;
            case "dividir":
                resultado = dividir(primerNumero, segundoNumero);
                break;
        }

        mostrarResultado(resultado, respuesta);

    }

}
