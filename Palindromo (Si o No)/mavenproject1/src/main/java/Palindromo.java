import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Escribe una palabra o frase:");
            String t = in.nextLine();
            
            // quitar espacios y pasar a minusculas
            t = t.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            
            String rev = "";
            for (int i = t.length() - 1; i >= 0; i--) {
                rev = rev + t.charAt(i);
            }
            
            if (t.equals(rev)) {
                System.out.println("Si es palindromo");
            } else {
                System.out.println("No es palindromo");
            }
        }
    }
}
