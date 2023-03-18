public class Ejercicio4 {
    public static void main(String[] args) {
        String[] productos = {"remera", "short", "top", "medias"};
        Double[] precios = {7500.99, 4860.02, 4200.00, 2479.99};

        System.out.println("La lista de productos de la tienda con sus precios es: ");
        for (int i = 0; i < productos.length; i++) {
            System.out.println("Producto " + (i+1) + ": " + productos[i] + " $" + precios[i]);
        }
    }
}
