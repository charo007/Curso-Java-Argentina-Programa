public class Ejercicio5 {
    public static void main(String[] args) {
        String cursos [] = {"Álgebra", "Programación", "Inglés"};
        int notas[] = {22, 18, 30};

        System.out.println("Promedio de notas de 3 cursos: ");

        int promedio = (notas[0] + notas[1] + notas[2]) / cursos.length;

        for (int i = 0; i < cursos.length; i++) {
            System.out.println("EL curso " + cursos[i] + " tiene " + notas[i] + " notas registradas.");
        }
        System.out.println("Por lo tanto, el promedio final de la cantidad de notas es: " + promedio);
    }
}
