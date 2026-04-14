public class Main {
    public static void main(String[] args) {
        Ordenamientos ordenador = new Ordenamientos();
        
        int[] datos = {38, 27, 43, 3, 9, 82, 10};
        
        System.out.println("Arreglo original:");
        imprimirArreglo(datos);

        ordenador.mergeSort(datos, 0, datos.length - 1);

        System.out.println("\nArreglo ordenado con Merge Sort:");
        imprimirArreglo(datos);
    }

    public static void imprimirArreglo(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}