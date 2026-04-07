import java.util.Scanner;


public class ex04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x,Y;

        System.out.print("Informe o valor de X --> ");
        x = sc.nextDouble();

        if (x >= -5 && x <= 5) {
            System.out.println("O valor é inválido");
            }
        else {
            double y = 8 / (Math.sqrt(Math.pow(x, 2) - 25));
            System.out.print("O valor de y é = " + y);
        }
    }
}
