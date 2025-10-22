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
 *  [38, 27, 43, 3] -> dividir -> [38, 27] y [43, 3]
 *  ordenar -> [27, 38] y [3, 43]
 *  merge -> [3, 27, 38, 43]
 */
public class MergeSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ===== ENTRADA =====
        // Pedimos una linea de numeros, separados por espacios o comas.
        System.out.println("Escribe numeros separados por espacio o coma:");
        String s = sc.nextLine().trim();

        // Normalizamos separadores:
        // - Reemplazamos coma por espacio
        // - Colapsamos multiples espacios en uno solo (regex \\s+)
        s = s.replace(",", " ").replaceAll("\\s+", " ");

        // Partimos la linea en tokens (cadenas) por espacio
        String[] t = s.split(" ");

        // Convertimos cada token a entero y lo guardamos en el arreglo 'a'
        int[] a = new int[t.length];
        for (int i = 0; i < t.length; i++) {
            // Integer.parseInt lanza NumberFormatException si un token no es numero
            // (mantenemos el codigo simple; asumimos que el usuario tecleo numeros validos)
            a[i] = Integer.parseInt(t[i]);
        }

        // Mostramos el arreglo original antes de ordenar
        System.out.println("Antes:  " + Arrays.toString(a));

        // ===== ORDENAMIENTO =====
        // Llamamos a mergeSort: divide -> ordena cada mitad -> combina con merge
        int[] ordenado = mergeSort(a);

        // Mostramos el resultado ya ordenado
        System.out.println("Despues: " + Arrays.toString(ordenado));

        sc.close();
    }

    /**
     * mergeSort:
     * - Caso base: si el arreglo tiene 0 o 1 elemento, ya esta ordenado; se regresa igual.
     * - Paso recursivo:
     *     a) Calcular punto medio (mid).
     *     b) Copiar mitad izquierda [0..mid) y mitad derecha [mid..n).
     *     c) Ordenar recursivamente ambas mitades.
     *     d) Combinar resultados con merge (intercalacion ordenada).
     */
    static int[] mergeSort(int[] a) {
        // Caso base: 0 o 1 elemento -> nada que ordenar
        if (a.length <= 1) return a;

        // Punto medio (mitad del arreglo)
        int mid = a.length / 2;

        // Subarreglo izquierda: indices 0 inclusive a mid exclusivo
        int[] izq = Arrays.copyOfRange(a, 0, mid);

        // Subarreglo derecha: indices mid inclusive a a.length exclusivo
        int[] der = Arrays.copyOfRange(a, mid, a.length);

        // Ordenamos recursivamente cada mitad
        int[] izqOrd = mergeSort(izq);
        int[] derOrd = mergeSort(der);

        // Combinamos dos arreglos ya ordenados en uno nuevo ordenado
        return merge(izqOrd, derOrd);
    }

    /**
     * merge:
     * Une dos arreglos YA ORDENADOS (izq y der) en un tercer arreglo ordenado.
     *
     * Mecanica:
     * - Usamos tres indices:
     *     i -> recorre la mitad izquierda (izq)
     *     j -> recorre la mitad derecha (der)
     *     k -> posicion de escritura en el arreglo resultado r
     * - En cada paso comparamos izq[i] y der[j]:
     *     - copiamos el menor a r[k] y avanzamos el puntero correspondiente
     * - Cuando una mitad se agota, copiamos las "sobras" de la otra mitad
     *
     * Nota sobre estabilidad:
     * - Usamos '<=' para que, si son iguales, tome primero el de la izquierda
     *   y se conserve el orden relativo original (algoritmo estable).
     */
    static int[] merge(int[] izq, int[] der) {
        // Arreglo resultado con tamano igual a la suma de ambos
        int[] r = new int[izq.length + der.length];

        // i: indice en izq, j: indice en der, k: indice en r (escritura)
        int i = 0, j = 0, k = 0;

        // Mientras haya elementos en ambas mitades, tomar siempre el menor
        while (i < izq.length && j < der.length) {
            if (izq[i] <= der[j]) {
                r[k++] = izq[i++];   // toma de izquierda y avanza i y k
            } else {
                r[k++] = der[j++];   // toma de derecha y avanza j y k
            }
        }

        // Copiar sobras de la izquierda (si quedo algo)
        while (i < izq.length) {
            r[k++] = izq[i++];
        }

        // Copiar sobras de la derecha (si quedo algo)
        while (j < der.length) {
            r[k++] = der[j++];
        }

        // r ya esta completamente ordenado
        return r;
    }
}
