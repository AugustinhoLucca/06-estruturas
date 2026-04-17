import java.util.Scanner;

public class ex066 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String turno;

        System.out.println("Qual é o seu turno? ");
        turno = sc.next();

        if (turno.equalsIgnoreCase("manha")) {
            System.out.println("O horário da aula é das 7h00 às 12h00");
        }
        else if (turno.equalsIgnoreCase("tarde")) {
            System.out.println("O horário da aula é das 13h00 às 18h00");
        }
        else if (turno.equalsIgnoreCase("noite")) {
            System.out.println("O horário da aula é das 19h00 às 23h00");
        }
        else {
            System.out.println("Modo de turno inválido!");
        }
    }
}
