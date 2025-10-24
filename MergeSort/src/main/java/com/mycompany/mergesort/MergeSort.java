package com.mycompany.mergesort;

import java.util.*;

/**
 * Idea general de Merge Sort (intercalacion):
 * 1) Dividir: partir el arreglo en dos mitades.
 * 2) Ordenar: aplicar mergeSort recursivamente a cada mitad.
 * 3) Combinar: unir las dos mitades ya ordenadas con merge tomando siempre el menor.
 *
 * Complejidad:
 * - Tiempo: O(n log n) (log n niveles, en cada nivel se procesan n elementos).
 * - Espacio: O(n) (se crean arreglos nuevos al combinar).
 *
 * Ejemplo rapido:
 *  [38.5, 27, 43.2, 3] -> dividir -> [38.5, 27] y [43.2, 3]
 *  ordenar -> [27, 38.5] y [3, 43.2]
 *  merge -> [3, 27, 38.5, 43.2]
 */
public class MergeSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // ===== ENTRADA =====
            System.out.println("Escribe numeros (pueden ser decimales) separados por espacio o coma:");
            String s = sc.nextLine().trim();

            // Normalizamos separadores:
            s = s.replace(",", " ").replaceAll("\\s+", " ");

            // Partimos la linea en tokens por espacio
            String[] t = s.split(" ");

            // Convertimos cada token a double y lo guardamos en el arreglo 'a'
            double[] a = new double[t.length];
            for (int i = 0; i < t.length; i++) {
                try {
                    a[i] = Double.parseDouble(t[i]);
                } catch (NumberFormatException nfe) {
                    System.out.println("Error: '" + t[i] + "' no es un numero valido.");
                    return; // Terminamos el programa si hay error de formato
                }
            }

            // Mostramos el arreglo original antes de ordenar
            System.out.println("Antes:  " + Arrays.toString(a));

            // ===== ORDENAMIENTO =====
            double[] ordenado = mergeSort(a);

            // Mostramos el resultado ya ordenado
            System.out.println("Despues: " + Arrays.toString(ordenado));
        } catch (Exception e) {
            System.out.println("Ocurrio un error inesperado: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    // Ahora mergeSort y merge usan double[] en vez de int[]
    static double[] mergeSort(double[] a) {
        if (a.length <= 1) return a;
        int mid = a.length / 2;
        double[] izq = Arrays.copyOfRange(a, 0, mid);
        double[] der = Arrays.copyOfRange(a, mid, a.length);
        double[] izqOrd = mergeSort(izq);
        double[] derOrd = mergeSort(der);
        return merge(izqOrd, derOrd);
    }

    static double[] merge(double[] izq, double[] der) {
        double[] r = new double[izq.length + der.length];
        int i = 0, j = 0, k = 0;
        while (i < izq.length && j < der.length) {
            if (izq[i] <= der[j]) {
                r[k++] = izq[i++];
            } else {
                r[k++] = der[j++];
            }
        }
        while (i < izq.length) {
            r[k++] = izq[i++];
        }
        while (j < der.length) {
            r[k++] = der[j++];
        }
        return r;
    }
}
