import java.util.Random;

public class NumerosAleatorios {
    public static void main(String[] args) {
        Random r = new Random();
        int[] nums = new int[10];
        int suma = 0;
        int max = 0;
        int min = 101;
        int pares = 0;
        int primos = 0;

        for (int i = 0; i < 10; i++) {
            nums[i] = r.nextInt(100) + 1;
            System.out.print(nums[i] + " ");
            suma += nums[i];
            if (nums[i] > max) max = nums[i];
            if (nums[i] < min) min = nums[i];
            if (nums[i] % 2 == 0) pares++;
            if (!esPrimo(nums[i])) {
            } else {
                primos++;
            }
        }
        System.out.println();
        System.out.println("Promedio: " + (suma / 10.0));
        System.out.println("Mayor: " + max);
        System.out.println("Menor: " + min);
        System.out.println("Pares: " + pares);
        System.out.println("Primos: " + primos);
    }

    static boolean esPrimo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
