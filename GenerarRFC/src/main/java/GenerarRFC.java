import java.util.Scanner;

public class GenerarRFC {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Apellido paterno: ");
            String ap = in.nextLine();
            System.out.print("Apellido materno: ");
            String am = in.nextLine();
            System.out.print("Nombre: ");
            String nom = in.nextLine();
            
            System.out.print("Año nacimiento (YYYY): ");
            int a = in.nextInt();
            System.out.print("Mes nacimiento: ");
            int m = in.nextInt();
            System.out.print("Dia nacimiento: ");
            int d = in.nextInt();
            
            String rfc = "";
            if (ap.length() >= 2) rfc += ap.substring(0,2);
            else rfc += (ap + "X").substring(0,2);
            
            if (am.length() >= 1) rfc += am.substring(0,1);
            else rfc += "X";
            
            rfc += nom.substring(0,1);
            rfc += String.format("%02d", a % 100);
            rfc += String.format("%02d", m);
            rfc += String.format("%02d", d);
            
            System.out.println("RFC: " + rfc.toUpperCase());
        }
    }
}
