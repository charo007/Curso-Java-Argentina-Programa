public class Ejercicio3 {
    public static void main(String[] args) {
        int[] numeros = new int[10];

        for (int i = 0; i < 10; i++) {
            numeros[i] = (i + 1) * 3;
            if (i == 6) {
                System.out.print("El número en la posición 6 dividido por 3 es: " + numeros[i] / 3);
            }
        }
    }
}
